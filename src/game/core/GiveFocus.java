package game.core;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * The GiveFocus class is a custom MouseAdapter that requests focus for the component
 * when the mouse enters its area.
 * This class is used to ensure that the component can receive input events, such as
 * key presses, when the user hovers over it with the mouse.
 */
public class GiveFocus extends MouseAdapter {

    /**
     * Requests focus for the component when the mouse enters the component's area.
     *
     * @param e the MouseEvent triggered when the mouse enters the component
     */
    @Override
    public void mouseEntered(MouseEvent e) {
        e.getComponent().requestFocus();
    }
}