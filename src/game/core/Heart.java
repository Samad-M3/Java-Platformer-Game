package game.core;

import city.cs.engine.*;

/**
 * Represents a collectible heart object that appears across all levels.
 * Hearts are used to increase the player's lives and are designed to float in the air.
 */
public class Heart extends DynamicBody {

    /**
     * The shape of the heart object.
     */
    private static final Shape heartShape = new BoxShape(0.7f, 0.7f);

    /**
     * The image of the heart object.
     */
    private static final BodyImage image = new BodyImage("data/pirateTheme/heart.png", 1.4f);

    /**
     * Constructor creates the hearts and sets its gravity to 0 to create the illusion that it is floating.
     *
     * @param world the world the heart object belongs to
     */
    public Heart(GameLevel world) {
        super(world, heartShape);
        this.addImage(image);
        this.setGravityScale(0);
    }
}