package game.level3;

import city.cs.engine.*;
import game.core.GameLevel;

/**
 * Represents the right portal in the world.
 */
public class RightPortal extends StaticBody {

    /**
     * The shape of the right portal.
     */
    private static final Shape portalShape = new BoxShape(0.8f, 1.6f);

    /**
     * The image displayed for the right portal.
     */
    private static final BodyImage image = new BodyImage("data/magicTheme/rightPortal.png", 3f);

    /**
     * Creates a new RightPortal in the specified world.
     *
     * @param world the world that the portal will be part of
     */
    public RightPortal(GameLevel world) {
        super(world, portalShape);
        this.addImage(image);
    }
}