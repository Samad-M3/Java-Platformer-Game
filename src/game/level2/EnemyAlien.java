package game.level2;

import city.cs.engine.*;
import game.core.GameLevel;
import game.core.DamageProneEnemy;
import org.jbox2d.common.Vec2;

/**
 * The EnemyAlien class represents an alien enemy in level 2.
 * It extends from DamageProneEnemy, which provides functionality for enemies that can take damage and move.
 */
public class EnemyAlien extends DamageProneEnemy {

    /**
     * Shape representing the alien.
     */
    private static final Shape enemyShape = new BoxShape(1.2f, 1.7f);

    /**
     * Image representing the alien facing right.
     */
    private static final BodyImage rightImage = new BodyImage("data/spaceTheme/alienRight.png", 4.5f);

    /**
     * Image representing the alien facing left.
     */
    private static final BodyImage leftImage = new BodyImage("data/spaceTheme/alienLeft.png", 4.5f);

    /**
     * Constructs a new EnemyAlien in the specified game world.
     * The alien is initialised with a shape and images for both directions.
     * It also starts at the given position and has a walking range and speed.
     *
     * @param world the world where the alien will exist and interact with other objects
     * @param startingPosition the position at which the alien will start in the world
     * @param halfWalkLength half of the walking range of the alien
     * @param speed The speed at which the alien moves during its patrol
     */
    public EnemyAlien(GameLevel world, Vec2 startingPosition, float halfWalkLength, float speed) {
        super(world, enemyShape, rightImage, leftImage, startingPosition, halfWalkLength, speed);
    }
}