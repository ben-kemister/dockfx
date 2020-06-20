package org.dockfx;

import java.util.function.Supplier;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Node;
import javafx.scene.control.CheckMenuItem;

/**
 * A {@link CheckMenuItem} where the selected state mirrors that of the {@link DockNode}'s state. 
 * This menu item also allows the visibility control of the {@link DockNode}.
 *
 * 
 * @author Kem
 * @since DockFX 0.2
 */
public class DockNodeMenuItem extends CheckMenuItem {

  
  private DockPane dockPane;
  private Supplier<Node> nodeContentSupplier;
  private DockNode dockNode;

  public DockNodeMenuItem(DockPane dockPane, Supplier<Node> nodeContentSupplier, String nodeTitle) {
    super(nodeTitle);
    this.dockPane = dockPane;
    this.nodeContentSupplier = nodeContentSupplier;
    setup();
  }

  private void setup() {
    
    this.setOnAction( actionEvent -> {
      
      if(this.isSelected()) {
        //Just been selected, create new DockNode
        
        dockNode = new DockNode(nodeContentSupplier.get(), this.getText());
        dockNode.dock(dockPane, DockPos.CENTER);
        
        dockNode.closedProperty().addListener(nodeClosedListener);
        
//        this.textProperty().bind(dockNode.titleProperty());
      } else {
        // UnSelected, close dock node
        
        if(dockNode != null) {
          dockNode.closableProperty().removeListener(nodeClosedListener);
          dockNode.close();
          dockNode = null;
        }
      }
      
    });
  }
  
  
  private ChangeListener<Boolean> nodeClosedListener = (ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) -> {
    
    // Make sure the state of the Menu item is up to date
    this.setSelected(!newValue);
    
    // If closed then, remove the Association with the panel.
    if(Boolean.TRUE.equals(newValue) && dockNode != null) {
        dockNode = null;
      }
  };
  
  
  
}
