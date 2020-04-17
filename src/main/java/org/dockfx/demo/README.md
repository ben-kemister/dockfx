# DockFX - Demo

This `README.md` provides additional information for running the DockFX Demo applications in Java 11.

## Developer Setup

### Eclipse Setup

To run the DockFX Demo applications from Eclipse you will need to add the VM Arguments as follows:


```
	--module-path ${PATH_TO_FX} --add-modules javafx.controls,javafx.fxml,javafx.web 
	--add-exports=javafx.graphics/com.sun.javafx.css=ALL-UNNAMED 
	--add-exports=javafx.graphics/com.sun.javafx.scene.input=ALL-UNNAMED 
	--add-exports=javafx.graphics/com.sun.javafx.util=ALL-UNNAMED 
	--add-exports=javafx.controls/com.sun.javafx.scene.control.behavior=ALL-UNNAMED 
	--add-exports=javafx.controls/com.sun.javafx.scene.control=ALL-UNNAMED
	--add-exports=javafx.controls/com.sun.javafx.scene.control.skin.resources=ALL-UNNAMED
```