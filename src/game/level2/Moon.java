package game.level2;

import city.cs.engine.*;
import game.core.GameLevel;

/**
 * The Moon class represents a dynamic body that functions as a collectible item in the game.
 * It is used in the Space theme level and has no gravity, allowing it to float in the world.
 */
public class Moon extends DynamicBody {

    /**
     * The shape of the moon.
     */
    private static final Shape moonShape = new CircleShape(0.8f);

    /**
     * The image representing the moon.
     */
    private static final BodyImage image = new BodyImage("data/spaceTheme/moon.png", 3f);

    /**
     * Constructs a Moon object with the specified world and assigns it the shape and image.
     * The moon is placed in the world and is set to have no gravity, to make it appear like its floating
     *
     * @param world the world in which the moon exists
     */
    public Moon(GameLevel world) {
        super(world, moonShape);
        this.addImage(image);
        this.setGravityScale(0);
    }
}