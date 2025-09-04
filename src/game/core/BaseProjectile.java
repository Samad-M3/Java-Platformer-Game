package game.core;

import city.cs.engine.*;

/**
 * Base class for all projectiles.
 */
public class BaseProjectile extends DynamicBody {

    /**
     * The shape of the projectile.
     */
    private final Shape projectileShape;

    /**
     * The image of the projectile facing left.
     */
    private final BodyImage leftImage;

    /**
     * The image of the projectile facing right.
     */
    private final BodyImage rightImage;

    /**
     * Creates a new projectile in a world.
     *
     * @param world the world the projectile belongs to
     * @param leftImage the image of the projectile facing left
     * @param rightImage the image of the projectile facing right
     */
    public BaseProjectile(GameLevel world, Shape projectileShape, BodyImage leftImage, BodyImage rightImage) {
        super(world, projectileShape);
        this.projectileShape = projectileShape;
        this.leftImage = leftImage;
        this.rightImage = rightImage;
    }

    /**
     * Allows any subclass to access the left image of the projectile.
     *
     * @return the left image of the projectile
     */
    public BodyImage getLeftImage() {
        return leftImage;
    }

    /**
     * Allows any subclass to access the right image of the projectile.
     *
     * @return the right image of the projectile
     */
    public BodyImage getRightImage() {
        return rightImage;
    }
}