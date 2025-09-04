package game.level2;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
import game.core.BreakablePlatform;
import game.core.Game;
import game.core.Heart;
import game.core.SoundManager;
import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The SpacePlayerCollisions class listens for and handles collisions between the player and various game objects.
 * It handles actions such as picking up items, taking damage, and interacting with the level's elements.
 */
public class SpacePlayerCollisions implements CollisionListener {

    /**
     * The player character in the Space-themed level.
     * This is used to update the player's stats when collisions occur.
     */
    private final AstronautPlayer player;

    /**
     * The world of the Space-themed level.
     * This is used to interact with the game world during collision events.
     */
    private final Level2 world;

    /**
     * The Game instance, used to interact with the overall game state, such as transitioning between levels.
     */
    private Game game;

    /**
     * A boolean flag indicating whether gravity boots are currently active for the player.
     * When active, gravity boots allow the player to jump higher.
     */
    private boolean gravityBootsActive = false;

    /**
     * Constructor for the SpacePlayerCollisions class.
     * Initializes the player, world, and game instances.
     *
     * @param player the player character for collision interactions
     * @param world the world of the current level
     * @param game the overall game instance
     */
    public SpacePlayerCollisions(AstronautPlayer player, Level2 world, Game game) {
        this.player = player;
        this.world = world;
        this.game = game;
    }

    /**
     * This method handles collision events between the player and other game objects.
     * The player can pick up items, take damage, and interact with platforms and other entities.
     *
     * @param e The collision event that contains the details of the collision
     */
    @Override
    public void collide(CollisionEvent e) {
        if (e.getOtherBody() instanceof BreakablePlatform) {
            Timer timer = new Timer(500, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ae) {
                    e.getOtherBody().destroy();
                }
            });
            timer.setRepeats(false);
            timer.start();
        }
        else if (e.getOtherBody() instanceof SpaceFlag) {
            SoundManager.play("victory");
            game.goToNextLevel();
        }
        else if (e.getOtherBody() instanceof Star) {
            player.setTotalStars(player.getTotalStars() + 1);
            SoundManager.play("star");
            e.getOtherBody().destroy();
        }
        else if (e.getOtherBody() instanceof Moon) {
            player.setTotalMoons(player.getTotalMoons() + 1);
            SoundManager.play("moon");
            e.getOtherBody().destroy();
        }
        else if (e.getOtherBody() instanceof MeteorLeft) {
            player.loseLives();
            SoundManager.play("playerDamage");
        }
        else if (e.getOtherBody() instanceof MeteorRight) {
            player.loseLives();
            SoundManager.play("playerDamage");
        }
        else if (e.getOtherBody() instanceof GravityBoots) {
            SoundManager.play("gravityBoots");
            gravityBootsActive = true;
            Timer timer = new Timer(15000, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ae) {
                    gravityBootsActive = false;
                }
            });
            timer.setRepeats(false);
            timer.start();
            e.getOtherBody().destroy();
        }
        else if (e.getOtherBody() instanceof Heart) {
            player.setLives(player.getLives() + 1);
            SoundManager.play("heart");
            e.getOtherBody().destroy();
        }
        else if (e.getOtherBody() instanceof bulletAmmo) {
            player.setNumOfBullets(player.getNumOfBullets() + 10);
            SoundManager.play("ammo");
            e.getOtherBody().destroy();
        }
        else if (e.getOtherBody() instanceof EnemyAlien) {
            player.loseLives();
            SoundManager.play("playerDamage");
        }
    }

    /**
     * Returns whether the gravity boots are currently active.
     *
     * @return true if gravity boots are active, false otherwise
     */
    public boolean getGravityBootsActive() {
        return gravityBootsActive;
    }
}