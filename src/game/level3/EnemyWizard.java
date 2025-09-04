package game.level3;

import city.cs.engine.*;
import game.core.GameLevel;
import game.core.DamageProneEnemy;
import org.jbox2d.common.Vec2;

/**
 * Represents an enemy wizard in Level 3 (Magic Theme).
 * The EnemyWizard is a damage-prone enemy that can move back and forth across a platform.
 * It has different images depending on whether it is moving left or right.
 */
public class EnemyWizard extends DamageProneEnemy {

    /**
     * The shape of the enemy wizard.
     */
    private static final Shape enemyShape = new BoxShape(1.2f, 1.7f);

    /**
     * The image of the enemy wizard when facing right.
     */
    private static final BodyImage rightImage = new BodyImage("data/magicTheme/enemyWizardRight.png", 5f);

    /**
     * The image of the enemy wizard when facing left.
     */
    private static final BodyImage leftImage = new BodyImage("data/magicTheme/enemyWizardLeft.png", 5f);

    /**
     * Constructs an EnemyWizard in the specified world.
     *
     * @param world the world where the enemyWizard will be placed
     * @param startingPosition the starting position of the enemy wizard in the world
     * @param halfWalkLength half of the walking range of the enemyWizard
     * @param speed the movement speed of the enemyWizard
     */
    public EnemyWizard(GameLevel world, Vec2 startingPosition, float halfWalkLength, float speed) {
        super(world, enemyShape, rightImage, leftImage, startingPosition, halfWalkLength, speed);
    }
}