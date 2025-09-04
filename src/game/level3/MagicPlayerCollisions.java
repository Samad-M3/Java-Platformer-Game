package game.level3;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
import game.core.BreakablePlatform;
import game.core.Game;
import game.core.Heart;
import game.core.SoundManager;
import org.jbox2d.common.Vec2;
import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * The MagicPlayerCollisions class handles the collision events between the player (WizardBasePlayer)
 * and various objects in the game world. It manages interactions with objects like portals, books, hearts,
 * fireball ammo, enemies, and magic potions, triggering appropriate game actions such as player movement,
 * health adjustments and sound effects.
 */
public class MagicPlayerCollisions implements CollisionListener {

    /**
     * The player instance (WizardPlayer) that will interact with the world.
     */
    private final WizardPlayer player;

    /**
     * The world (Level3) that the player exists in, containing all physical bodies and game logic.
     */
    private final Level3 world;

    /**
     * The game instance, used to manage overall game progression and level transitions.
     */
    private Game game;

    /**
     * A list of right portals the player can interact with.
     * Each portal teleports the player to a specific location in the world.
     */
    private final ArrayList<RightPortal> rightPortals;

    /**
     * A list of left portals the player can interact with.
     * Each portal teleports the player to a specific location in the world.
     */
    private final ArrayList<LeftPortal> leftPortals;

    /**
     * Constructs a MagicPlayerCollisions object to manage the player's collision events.
     *
     * @param player the WizardBasePlayer instance representing the player
     * @param world the Level3 instance that contains the world
     * @param game the game instance to manage game progression
     */
    public MagicPlayerCollisions(WizardPlayer player, Level3 world, Game game) {
        this.player = player;
        this.world = world;
        this.game = game;
        this.rightPortals = new ArrayList<>();
        this.leftPortals = new ArrayList<>();
    }

    /**
     * Handles collision events between the player and various objects in the game world.
     * Depending on the type of collision, different actions are triggered, such as
     * player movement, item collection, health modification, or level progression.
     *
     * @param e The CollisionEvent that provides information about the collision.
     */
    @Override
    public void collide(CollisionEvent e) {
        if (e.getOtherBody() instanceof MagicFlag) {
            SoundManager.play("victory");
            world.getView().setGameOver(true);
            world.stop();
            game.goToNextLevel();
        }
        else if (e.getOtherBody() instanceof RightPortal) {
            SoundManager.play("portal");
            if (rightPortals.get(0) == e.getOtherBody()) {
                player.setPosition(new Vec2(-9.8f, 79f));
            }
            else if (rightPortals.get(1) == e.getOtherBody()) {
                player.setPosition(new Vec2(-9.8f ,132.2f));
            }
            else if (rightPortals.get(2) == e.getOtherBody()) {
                player.setPosition(new Vec2(-9.8f ,192.7f));
            }
        }
        else if (e.getOtherBody() instanceof LeftPortal) {
            SoundManager.play("portal");
            if (leftPortals.get(0) == e.getOtherBody()) {
                player.setPosition(new Vec2(9.8f, 63f));
            }
            else if (leftPortals.get(1) == e.getOtherBody()) {
                player.setPosition(new Vec2(9.8f ,122f));
            }
            else if (leftPortals.get(2) == e.getOtherBody()) {
                player.setPosition(new Vec2(9.8f ,174f));
            }
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
        else if (e.getOtherBody() instanceof PinkMagicBook) {
            SoundManager.play("book");
            player.setTotalPinkBooks(player.getTotalPinkBooks() + 1);
            e.getOtherBody().destroy();
        }
        else if (e.getOtherBody() instanceof BlueMagicBook) {
            SoundManager.play("book");
            player.setTotalBlueBooks(player.getTotalBlueBooks() + 1);
            e.getOtherBody().destroy();
        }
        else if (e.getOtherBody() instanceof Heart) {
            player.setLives(player.getLives() + 1);
            SoundManager.play("heart");
            e.getOtherBody().destroy();
        }
        else if (e.getOtherBody() instanceof FireballAmmo) {
            SoundManager.play("fireballPickup");
            player.setNumOfFireballs(player.getNumOfFireballs() + 25);
            e.getOtherBody().destroy();
        }
        else if (e.getOtherBody() instanceof EnemyWizard) {
            player.loseLives();
            SoundManager.play("playerDamage");
        }
        else if (e.getOtherBody() instanceof MagicPotion) {
            player.loseLives();
            SoundManager.play("potion");
            SoundManager.play("playerDamage");
            Timer timer = new Timer(2000, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ae) {
                    e.getOtherBody().destroy();
                }
            });
            timer.setRepeats(false);
            timer.start();
        }
    }

    /**
     * Adds a right portal to the list of right portals.
     *
     * @param portal The RightPortal to be added.
     */
    public void addRightPortal(RightPortal portal) {
        rightPortals.add(portal);
    }

    /**
     * Adds a left portal to the list of left portals.
     *
     * @param portal The LeftPortal to be added.
     */
    public void addLeftPortal(LeftPortal portal) {
        leftPortals.add(portal);
    }
}