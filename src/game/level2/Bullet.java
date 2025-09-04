package game.level2;

import city.cs.engine.*;
import game.core.GameLevel;
import game.core.BaseProjectile;

/**
 * The Bullet class represents a projectile that the astronaut player can shoot in level 2.
 * It extends from BaseProjectile and defines the shape and images for the bullet as well as the behavior for gravity.
 */
public class Bullet extends BaseProjectile {

    /**
     * Shape representing the bullet.
     */
    private static final Shape bulletShape = new BoxShape(0.5f, 0.25f);

    /**
     * Image representing the bullet when it is moving to the left.
     */
    private static final BodyImage leftImage = new BodyImage("data/spaceTheme/bulletLeft.png", 2.5f);

    /**
     * Image representing the bullet when it is moving to the right.
     */
    private static final BodyImage rightImage = new BodyImage("data/spaceTheme/bulletRight.png", 2.5f);

    /**
     * Constructs a new bullet in the specified game world.
     * The bullet is initialised with a shape, images for both directions, and no gravity to make it
     * appear as if its floating.
     *
     * @param world the world where the bullet will exist and interact with other objects
     */
    public Bullet(GameLevel world) {
        super(world, bulletShape, leftImage, rightImage);
        this.setGravityScale(0);
    }
}