package game.level1;

import city.cs.engine.*;
import game.core.GameLevel;
import game.core.BaseEnemy;
import org.jbox2d.common.Vec2;

/**
 * The EnemyPirate class represents a pirate enemy in level 1.
 * It inherits from the BaseEnemy class and sets the specific shape, images, and behavior for the pirate enemy.
 * The enemy has two images (one for each direction) and can move back and forth within a given distance.
 */
public class EnemyPirate extends BaseEnemy {

    /**
     * Shape of the enemy.
     */
    private static final Shape enemyShape = new PolygonShape(-0.27f,1.45f, 0.47f,1.3f, 0.73f,-1.52f, -0.77f,-1.51f, -0.88f,0.73f, -0.37f,1.4f);

    /**
     * Image of the pirate facing right.
     */
    private static final BodyImage rightImage = new BodyImage("data/pirateTheme/pirate.png", 3.3f);

    /**
     * Image of the pirate facing left.
     */
    private static final BodyImage leftImage = new BodyImage("data/pirateTheme/pirate_flipped.png", 3.3f);

    /**
     * Constructs an EnemyPirate object in the specified world with the given starting position, walk length, and speed.
     * The pirate moves back and forth, switching images based on direction.
     *
     * @param world the world where the enemy pirate will be placed
     * @param startingPosition the initial position of the enemy pirate
     * @param halfWalkLength the length at which the enemy travels either side
     * @param speed the speed at which the pirate moves at
     */
    public EnemyPirate(GameLevel world, Vec2 startingPosition, float halfWalkLength, float speed) {
        super(world, enemyShape, rightImage, leftImage, startingPosition, halfWalkLength, speed);
    }
}