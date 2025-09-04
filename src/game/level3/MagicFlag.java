package game.level3;

import city.cs.engine.*;
import game.core.GameLevel;

/**
 * Represents a magic flag in the game.
 * This flag is used to mark the end of the game.
 */
public class MagicFlag extends StaticBody {

    /**
     * The shape of the flag.
     */
    private static final Shape flagShape = new PolygonShape(0.93f,1.98f, -1.06f,1.06f, -1.34f,-0.26f, 0.86f,-1.98f, 1.25f,-1.98f, 1.26f,1.99f);

    /**
     * The image displayed for the flag.
     */
    private static final BodyImage image = new BodyImage("data/magicTheme/whiteFlag.png", 4);

    /**
     * Creates a new MagicFlag.
     *
     * @param world the world that the flag will belong to
     */
    public MagicFlag(GameLevel world) {
        super(world, flagShape);
        this.addImage(image);
    }
}