package game.level2;

import city.cs.engine.*;
import game.core.GameLevel;

/**
 * The Star class represents a collectible star object in the Space-themed level.
 */
public class Star extends DynamicBody {

    /**
     * The shape of the star.
     */
    private static final Shape starShape = new CircleShape(0.8f);

    /**
     * The image of the star.
     */
    private static final BodyImage image = new BodyImage("data/spaceTheme/star.png", 1.7f);

    /**
     * Constructs a Star in the specified world.
     * This method creates the star's shape and assigns it an image.
     *
     * @param world the world where the star exists.
     */
    public Star(GameLevel world) {
        super(world, starShape);
        this.addImage(image);
        this.setGravityScale(0);
    }
}