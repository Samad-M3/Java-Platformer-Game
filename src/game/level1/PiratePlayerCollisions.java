package game.level1;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
import game.core.SoundManager;
import game.core.BreakablePlatform;
import game.core.Game;
import game.core.Heart;
import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Handles collision events for the Pirate Player in Level 1.
 * This class listens for collisions between the PiratePlayer and various objects in level 1, such as coins,
 * breakable platforms, treasure chests, hearts, enemies, spikes, and the pirate flag. It performs actions such as
 * updating the player's coins, lives, or triggering sound effects upon collision.
 */
public class PiratePlayerCollisions implements CollisionListener {

    /**
     * We declare a PiratePlayer object which we use in the actual collisions between bodies, so for
     * example to update the number of coins collected so far by the player
     */
    private final PiratePlayer player;

    /**
     * The Level1 world in which the collisions occur.
     */
    private final Level1 world;

    /**
     * The Game instance used to transition between levels.
     */
    private Game game;

    /**
     * Constructs a new PiratePlayerCollisions instance.
     *
     * @param player The PiratePlayer instance to track collisions for
     * @param world  The Level1 world where the player exists
     * @param game   The Game instance to transition between levels
     */
    public PiratePlayerCollisions(PiratePlayer player, Level1 world, Game game) {
        this.player = player;
        this.world = world;
        this.game = game;
    }

    /**
     * Handles the collision event by checking the type of the other body involved in the collision and performing
     * the corresponding action.
     *
     * @param e The CollisionEvent that contains information about the collision
     */
    @Override
    public void collide(CollisionEvent e) {
        if (e.getOtherBody() instanceof Coin) {
            player.setCoins(player.getCoins() + 1);
            SoundManager.play("coin");
            e.getOtherBody().destroy();
        }
        else if (e.getOtherBody() instanceof BreakablePlatform) {
            Timer timer = new Timer(500, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ae) {
                    e.getOtherBody().destroy();
                }
            });
            timer.setRepeats(false);
            timer.start();
        }
        else if (e.getOtherBody() instanceof TreasureChest) {
            player.setCoins(player.getCoins() + 10);
            SoundManager.play("treasureChest");
            e.getOtherBody().destroy();
        }
        else if (e.getOtherBody() instanceof Heart) {
            player.setLives(player.getLives() + 1);
            SoundManager.play("heart");
            e.getOtherBody().destroy();
        }
        else if (e.getOtherBody() instanceof EnemyPirate) {
            player.loseLives();
            SoundManager.play("playerDamage");
        }
        else if (e.getOtherBody() instanceof Spike) {
            player.loseLives();
            SoundManager.play("playerDamage");
        }
        else if (e.getOtherBody() instanceof PirateFlag) {
            SoundManager.play("victory");
            game.goToNextLevel();
        }
    }
}