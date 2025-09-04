package game.level2;

import city.cs.engine.*;
import game.core.GameLevel;

/**
 * The SpaceFlag class represents the flag at the end of the Space-themed level.
 * It is placed as a static body with a flag shape and an image of an American flag.
 */
public class SpaceFlag extends StaticBody {

    /**
     * The shape of the flag.
     */
    private static final Shape flagShape = new PolygonShape(-1.35f,1.93f, 1.52f,1.6f, 1.53f,0.04f, -1.26f,-1.89f, -1.46f,-1.89f, -1.52f,1.79f);

    /**
     * The image of the flag, representing the American flag.
     */
    private static final BodyImage image = new BodyImage("data/spaceTheme/americanFlag.png", 4);

    /**
     * Constructs a SpaceFlag in the specified world.
     * This method creates the flag's shape and assigns it an image.
     *
     * @param world the world where the flag exists
     */
    public SpaceFlag(GameLevel world) {
        super(world, flagShape);
        this.addImage(image);
    }
}