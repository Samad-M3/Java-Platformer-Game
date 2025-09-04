package game.core;

import java.awt.Color;

/**
 * Create a breakable platform.
 */
public class BreakablePlatform extends Platform {

    /**
     * Create a breakable platform and set its colour to white.
     *
     * @param world the world the breakable platform belongs to
     */
    public BreakablePlatform(GameLevel world) {
        super(world);
        this.setFillColor(new Color(255, 255, 255, 180));
    }
}