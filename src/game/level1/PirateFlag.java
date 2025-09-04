package game.level1;

import city.cs.engine.*;
import game.core.GameLevel;

/**
 * The PirateFlag class represents a flag object in level 1.
 * This class is used to represent the flag that the player will interact with in order to progress onto
 * the next level within the game.
 */
public class PirateFlag extends StaticBody {

    /**
     * Shape of the flag.
     */
    private static final Shape flagShape = new PolygonShape(-1.06f,1.55f, -0.62f,1.55f, 1.18f,1.07f, 1.17f,-0.42f, -0.45f,-1.5f, -1.18f,-1.5f, -1.14f,1.48f);

    /**
     * Image of the flag.
     */
    private static final BodyImage image = new BodyImage("data/pirateTheme/flag.png", 4);

    /**
     * Constructs a new PirateFlag object and adds it to the specified game world.
     *
     * @param world the world in which the flag will be added to
     */
    public PirateFlag(GameLevel world) {
        super(world, flagShape);
        this.addImage(image);
    }
}