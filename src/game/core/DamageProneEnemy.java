package game.core;

import city.cs.engine.BodyImage;
import city.cs.engine.Shape;
import org.jbox2d.common.Vec2;

/**
 * Subclass of BaseEnemy which implements health to the enemies.
 */
public class DamageProneEnemy extends BaseEnemy {

    /**
     * The health of the enemy, which starts at 100.
     */
    private float health;

    /**
     * Creates a patrolling enemy that is now susceptible to incoming damage.
     *
     * @param world the world the enemy belongs to
     * @param shape the shape that the enemy has
     * @param rightImage the image of the enemy looking to the right
     * @param leftImage the image of the enemy looking to the left
     * @param startingPos the position of where the enemy is placed in the world and starts moving from
     * @param halfWalkLength the length at which the enemy travel either side
     * @param speed the movement speed at which the enemy travels at
     */
    public DamageProneEnemy(GameLevel world, Shape shape, BodyImage rightImage, BodyImage leftImage, Vec2 startingPos, float halfWalkLength, float speed) {
        super(world, shape, rightImage, leftImage, startingPos, halfWalkLength, speed);
        this.health = 100;
    }

    /**
     * Each time this method is called the enemy loses health by a value of 20, if their health is less than
     * or equal to 0, then the enemy is destroyed immediately.
     */
    public void loseHealth() {
        health -= 20;
        if (health <= 0) {
            this.destroy();
        }
    }
}