package game.level3;

import city.cs.engine.*;
import game.core.GameLevel;
import game.core.BaseProjectile;

/**
 * Represents a fireball projectile used by the player or enemies in Level 3 (Magic Theme).
 * The Fireball moves horizontally and is not affected by gravity.
 * It displays a different image depending on its direction of movement.
 */
public class Fireball extends BaseProjectile {

    /**
     * The shape of the fireball.
     */
    private static final Shape fireballShape = new CircleShape(0.6f);

    /**
     * The image of the fireball when facing left.
     */
    private static final BodyImage leftImage = new BodyImage("data/magicTheme/fireballLeft.png", 2.2f);

    /**
     * The image of the fireball when facing right.
     */
    private static final BodyImage rightImage = new BodyImage("data/magicTheme/fireballRight.png", 2.2f);

    /**
     * Constructs a Fireball object in the given world.
     *
     * @param world the world where the fireball will exist
     */
    public Fireball(GameLevel world) {
        super(world, fireballShape, leftImage, rightImage);
        this.setGravityScale(0);
    }
}