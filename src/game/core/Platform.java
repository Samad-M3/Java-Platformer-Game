package game.core;

import city.cs.engine.*;
import java.awt.Color;

/**
 * A basic static platform that appears in every level.
 * Provides a simple flat surface for the player to stand or jump on.
 */
public class Platform extends StaticBody {

    /**
     * The shape of the platform.
     */
    private static final Shape platformShape = new BoxShape(1.5f, 0.3f);

    /**
     * Creates the platform and sets it to a washed blue colour.
     *
     * @param world the world that this platform belongs to
     */
    public Platform(GameLevel world) {
        super(world, platformShape);
        this.setFillColor(new Color(160, 220, 204, 180));
    }
}