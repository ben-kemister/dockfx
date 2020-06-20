package org.dockfx;

import javafx.beans.NamedArg;
import javafx.event.Event;
import javafx.event.EventType;

/**
 * Events related to {@link DockNode} showing/closing actions.
 * 
 * @author Ben Kemister
 * @since DockFX 0.2
 *
 */
public class DockNodeEvent extends Event {
  
  /**
   * Generated serial version.
   */
  private static final long serialVersionUID = 5616977393701219538L;

  /**
   * Common supertype for all {@link DockNode} event types.
   */
  public static final EventType<DockNodeEvent> ANY =
          new EventType<>(Event.ANY, "DOCK_NODE");
  
  /**
   * This event occurs after the {@link DockNode} has closed. 
   * 
   * (i.e. the close method has been invoked).
   */
  public static final EventType<DockNodeEvent> NODE_CLOSED = 
        new EventType<>(DockNodeEvent.ANY, "NODE_CLOSED");
  
  
  /**
   * Construct a new {@code DockNodeEvent} with the specified event source, target
   * and type. If the source or target is set to {@code null}, it is replaced
   * by the {@code NULL_SOURCE_TARGET} value.
   *
   * @param source    the event source which sent the event
   * @param eventType the event type
   */
  public DockNodeEvent(final @NamedArg("source") DockNode source, final @NamedArg("eventType") EventType<? extends Event> eventType) {
      super(source, source, eventType);
  }

}
