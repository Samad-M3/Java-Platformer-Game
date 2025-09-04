package game.level3;

import city.cs.engine.*;
import game.core.GameLevel;

/**
 * Represents a collectible fireball ammunition item in Level 3 (Magic Theme).
 * Picking up a FireballAmmo could allow the player to gain or replenish fireball projectiles.
 * It floats without being affected by gravity.
 */
public class FireballAmmo extends DynamicBody {

    /**
     * The shape of the fireball ammo.
     */
    private static final Shape ammoShape = new CircleShape(0.8f);

    /**
     * The image used to represent the fireball ammo.
     */
    private static final BodyImage image = new BodyImage("data/magicTheme/ammo.png", 2.2f);

    /**
     * Constructs a FireballAmmo object in the given world.
     *
     * @param world the world where the fireball ammo will exist
     */
    public FireballAmmo(GameLevel world) {
        super(world, ammoShape);
        this.addImage(image);
        this.setGravityScale(0);
    }
}