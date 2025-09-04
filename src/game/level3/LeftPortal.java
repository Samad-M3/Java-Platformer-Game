package game.level3;

import city.cs.engine.*;
import game.core.GameLevel;

/**
 * Represents a static left portal in Level 3 (Magic Theme).
 * The LeftPortal is a fixed object that is used for teleportation.
 */
public class LeftPortal extends StaticBody {

    /**
     * The shape of the left portal.
     */
    private static final Shape portalShape = new BoxShape(0.8f, 1.6f);

    /**
     * The image used to represent the left portal.
     */
    private static final BodyImage image = new BodyImage("data/magicTheme/leftPortal.png", 3f);

    /**
     * Constructs a LeftPortal object in the given world.
     *
     * @param world the world where the left portal will exist
     */
    public LeftPortal(GameLevel world) {
        super(world, portalShape);
        this.addImage(image);
    }
}