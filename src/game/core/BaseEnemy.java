package game.core;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

/**
 * Base class for all enemies.
 */
public class BaseEnemy extends Walker implements StepListener {

    /**
     * The image of the enemy facing right.
     */
    private final BodyImage rightImage;

    /**
     * The image of the enemy facing left.
     */
    private final BodyImage leftImage;

    /**
     * The leftmost x-position the enemy can travel to.
     */
    private final float maxLeft;

    /**
     * The rightmost x-position the enemy can travel to.
     */
    private final float maxRight;

    /**
     * The movement speed of the enemy.
     */
    private final float speed;

    /**
     * The current movement direction (1 for right, -1 for left).
     */
    private int direction;

    /**
     * Creates a patrolling enemy.
     *
     * Creates a new enemy in a world and can be positioned somewhere in that world, when creating an enemy
     * you choose how far the enemy should travel in the x-axis and how fast the enemy can move.
     *
     * @param world the world the enemy belongs to
     * @param shape the shape that the enemy has
     * @param rightImage the image of the enemy looking to the right
     * @param leftImage the image of the enemy looking to the left
     * @param startingPos the position of where the enemy is placed in the world and starts moving from
     * @param halfWalkLength the length at which the enemy travels either side
     * @param speed the movement speed at which the enemy travels at
     */
    public BaseEnemy(GameLevel world, Shape shape, BodyImage rightImage, BodyImage leftImage, Vec2 startingPos, float halfWalkLength, float speed) {
        super(world, shape);
        this.rightImage = rightImage;
        this.leftImage = leftImage;
        this.addImage(rightImage);
        this.setPosition(startingPos);
        this.maxLeft = startingPos.x - halfWalkLength;
        this.maxRight = startingPos.x + halfWalkLength;
        this.speed = speed;
        this.direction = 1;
        world.addStepListener(this);
    }

    /**
     * Called before each simulation step.
     *
     * @param stepEvent the event containing information about the current step
     */
    @Override
    public void preStep(StepEvent stepEvent) {}

    /**
     * Called after each simulation step.
     *
     * Tracks where the enemy is based on the x-axis, if the enemy is greater than maxRight or less than
     * maxLeft, which is how far the enemy can travel to the right or to the left respectively,
     * then change its direction, remove all images, add the opposite image of the enemy, then it starts
     * moving.
     *
     * @param stepEvent the event containing information about the current step
     */
    @Override
    public void postStep(StepEvent stepEvent) {
        if (this.getPosition().x > maxRight) {
            direction *= -1;
            this.removeAllImages();
            this.addImage(leftImage);
        }
        if (this.getPosition().x < maxLeft) {
            direction *= -1;
            this.removeAllImages();
            this.addImage(rightImage);
        }
        this.startWalking(speed * direction);
    }
}