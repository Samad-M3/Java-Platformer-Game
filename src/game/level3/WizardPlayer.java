package game.level3;

import city.cs.engine.*;
import game.core.GameLevel;
import game.core.BasePlayer;
import game.core.SoundManager;
import org.jbox2d.common.Vec2;
import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Represents the wizard player in the game. This player can interact with enemies,
 * collect items, shoot fireballs, and perform various actions in the game world.
 * The player has health, fireball count, and can collect books that contribute
 * to their stats.
 */
public class WizardPlayer extends BasePlayer implements CollisionListener {

    /**
     * The shape of the wizard character.
     */
    private static final Shape rightPlayerShape = new BoxShape(1f, 1.8f);

    /**
     * The image displayed for the wizard facing right.
     */
    private static final BodyImage rightPlayerImage = new BodyImage("data/magicTheme/wizardRight.png", 6f);

    /**
     * Total number of pink books collected by the player.
     */
    private int totalPinkBooks = 0;

    /**
     * Total number of blue books collected by the player.
     */
    private int totalBlueBooks = 0;

    /**
     * The number of fireballs the player can shoot.
     */
    private int numOfFireballs;

    /**
     * The list of enemy wizards in the game.
     */
    private final ArrayList<EnemyWizard> enemies;

    /**
     * Creates a new wizard player in the specified world
     *
     * @param world the world that the wizard will be part of
     */
    public WizardPlayer(GameLevel world) {
        super(world, rightPlayerShape, rightPlayerImage);
        this.numOfFireballs = 10;
        this.enemies = new ArrayList<>();
    }

    /**
     * Sets the total number of pink books the wizard has collected.
     *
     * @param totalPinkBooks the total number of pink books
     */
    public void setTotalPinkBooks(int totalPinkBooks) {
        this.totalPinkBooks = totalPinkBooks;
    }

    /**
     * Returns the total number of pink books collected by the wizard.
     *
     * @return the total number of pink books
     */
    public int getTotalPinkBooks() {
        return totalPinkBooks;
    }

    /**
     * Sets the total number of blue books the wizard has collected.
     *
     * @param totalBlueBooks the total number of blue books
     */
    public void setTotalBlueBooks(int totalBlueBooks) {
        this.totalBlueBooks = totalBlueBooks;
    }

    /**
     * Returns the total number of blue books collected by the wizard.
     *
     * @return the total number of blue books
     */
    public int getTotalBlueBooks() {
        return totalBlueBooks;
    }

    /**
     * Sets the number of fireballs available to the wizard.
     *
     * @param numOfFireballs the number of fireballs
     */
    public void setNumOfFireballs(int numOfFireballs) {
        this.numOfFireballs = numOfFireballs;
    }

    /**
     * Returns the number of fireballs available to the wizard.
     *
     * @return the number of fireballs
     */
    public int getNumOfFireballs() {
        return numOfFireballs;
    }

    /**
     * Shoots a fireball in the direction the wizard is facing. The fireball will
     * be created at the wizard's current position and will travel in the direction
     * determined by the wizard's facing direction.
     */
    public void shoot() {
        Fireball fireball = new Fireball(getWorld());
        fireball.addCollisionListener(this);
        if (this.getWorld().getGame().getController().isFacingRight()) {
            fireball.setPosition(new Vec2(this.getPosition().x + 1.2f, this.getPosition().y - 0.1f));
            fireball.addImage(fireball.getRightImage());
            fireball.setLinearVelocity(new Vec2(20f, 0));
        }
        else {
            fireball.setPosition(new Vec2(this.getPosition().x - 1.2f, this.getPosition().y - 0.1f));
            fireball.addImage(fireball.getLeftImage());
            fireball.setLinearVelocity(new Vec2(-20f, 0f));
        }
    }

    /**
     * Adds an enemy wizard to the list of enemies that the wizard will interact with.
     *
     * @param enemy the enemy wizard to be added
     */
    public void addEnemies(EnemyWizard enemy) {
        enemies.add(enemy);
    }

    /**
     * Handles the collision between the fireball and other objects, and what should happen as a result
     * of a fireball hitting something
     *
     * @param e the collision event
     */
    @Override
    public void collide(CollisionEvent e) {
        if (e.getOtherBody() instanceof EnemyWizard) {
            SoundManager.play("enemyWizardDamage");
            for (int i = 0; i < enemies.size(); i++) {
                if (enemies.get(i) == e.getOtherBody()) {
                    e.getReportingBody().destroy();
                    enemies.get(i).loseHealth();
                }
            }
        }
        else if (e.getOtherBody() instanceof MagicPotion) {
            SoundManager.play("potion");
            Timer timer = new Timer(1000, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ae) {
                    e.getOtherBody().destroy();
                }
            });
            timer.setRepeats(false);
            timer.start();
        }
        Timer timer = new Timer(2000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                e.getReportingBody().destroy();
            }
        });
        timer.setRepeats(false);
        timer.start();
    }
}