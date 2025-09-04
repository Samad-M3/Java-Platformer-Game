package game.core;

import city.cs.engine.*;
import game.level1.PiratePlayer;
import game.level2.AstronautPlayer;
import game.level2.SpacePlayerCollisions;
import game.level3.WizardPlayer;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * A controller class that handles keyboard inputs for different types of players.
 *
 * Depending on the active player (Pirate, Astronaut, or Wizard),
 * the controls allow movement (left, right, jump) and shooting actions.
 * Also handles pausing the game with the Escape or P keys.
 */
public class PlayerController implements KeyListener {

    /**
     * The player that the controller is currently managing.
     */
    private BasePlayer basePlayer;

    /**
     * Reference to the game window, used for opening panels such as pause menu.
     */
    private GameWindow gameWindow;

    /**
     * Specific collision handler for astronaut player, specifically to do with the setting of the
     * ability of gravity boots
     */
    private SpacePlayerCollisions spc;

    /**
     * Flag indicating if the player is currently facing left.
     */
    private boolean facingLeft = true;

    /**
     * Flag indicating if the player is currently facing right.
     */
    private boolean facingRight = true;

    /**
     * Creates a new PlayerController for a player and game window.
     *
     * @param basePlayer the player this controller will manage
     * @param gameWindow the game window this controller interacts with
     */
    PlayerController(BasePlayer basePlayer, GameWindow gameWindow) {
        this.basePlayer = basePlayer;
        this.gameWindow = gameWindow;
    }

    /**
     * Handles key presses to move or perform actions with the player.
     *
     * @param e the event triggered by a key press
     */
    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();

        if (code == KeyEvent.VK_ESCAPE || code == KeyEvent.VK_P) {
            basePlayer.getWorld().stop();
            gameWindow.getPauseMenuPanel();
        }

        if (basePlayer instanceof PiratePlayer) {
            if (code == KeyEvent.VK_A) {
                basePlayer.startWalking(-10);
                basePlayer.removeAllImages();
                basePlayer.addImage(new BodyImage("data/pirateTheme/captain.png", 3f));
            }
            else if (code == KeyEvent.VK_D) {
                basePlayer.startWalking(10);
                basePlayer.removeAllImages();
                basePlayer.addImage(new BodyImage("data/pirateTheme/captain_flipped.png", 3f));
            }
            else if (code == KeyEvent.VK_W) {
                basePlayer.jump(10);
            }
        }
        else if (basePlayer instanceof AstronautPlayer) {
            if (code == KeyEvent.VK_A) {
                basePlayer.startWalking(-10);
                basePlayer.removeAllImages();
                basePlayer.addImage(new BodyImage("data/spaceTheme/astronautLeft.png", 4f));
                facingLeft = true;
            }
            else if (code == KeyEvent.VK_D) {
                basePlayer.startWalking(10);
                basePlayer.removeAllImages();
                basePlayer.addImage(new BodyImage("data/spaceTheme/astronautRight.png", 4f));
                facingLeft = false;
            }
            else if (code == KeyEvent.VK_W) {
                if (spc.getGravityBootsActive()) {
                    basePlayer.jump(20);
                }
                else {
                    basePlayer.jump(10);
                }
            }
            else if (code == KeyEvent.VK_SPACE) {
                if (((AstronautPlayer) basePlayer).getNumOfBullets() != 0) {
                    ((AstronautPlayer) basePlayer).shoot();
                    SoundManager.play("pewpew");
                    ((AstronautPlayer) basePlayer).setNumOfBullets(((AstronautPlayer) basePlayer).getNumOfBullets() - 1);
                }
            }
        }
        else if (basePlayer instanceof WizardPlayer) {
            if (code == KeyEvent.VK_A) {
                basePlayer.startWalking(-10);
                basePlayer.removeAllImages();
                basePlayer.addImage(new BodyImage("data/magicTheme/wizardLeft.png", 6f));
                facingRight = false;
            }
            else if (code == KeyEvent.VK_D) {
                basePlayer.startWalking(10);
                basePlayer.removeAllImages();
                basePlayer.addImage(new BodyImage("data/magicTheme/wizardRight.png", 6f));
                facingRight = true;
            }
            else if (code == KeyEvent.VK_W) {
                basePlayer.jump(10);
            }
            else if (code == KeyEvent.VK_SPACE) {
                if (((WizardPlayer) basePlayer).getNumOfFireballs() != 0) {
                    ((WizardPlayer) basePlayer).shoot();
                    SoundManager.play("fireballShooting");
                    ((WizardPlayer) basePlayer).setNumOfFireballs(((WizardPlayer) basePlayer).getNumOfFireballs() - 1);
                }
            }
        }
    }

    /**
     * Handles key releases to stop player movement when necessary.
     *
     * @param e the event triggered by a key release
     */
    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        if (basePlayer instanceof PiratePlayer) {
            if (code == KeyEvent.VK_A) {
                basePlayer.startWalking(0);
            }
            else if (code == KeyEvent.VK_D) {
                basePlayer.startWalking(0);
            }
        }
        else if (basePlayer instanceof AstronautPlayer) {
            if (code == KeyEvent.VK_A) {
                basePlayer.startWalking(0);
            }
            else if (code == KeyEvent.VK_D) {
                basePlayer.startWalking(0);
            }
        }
        else if (basePlayer instanceof WizardPlayer) {
            if (code == KeyEvent.VK_A) {
                basePlayer.startWalking(0);
            }
            else if (code == KeyEvent.VK_D) {
                basePlayer.startWalking(0);
            }
        }
    }

    /**
     * Handles key typing events.
     *
     * @param e the event triggered by key typing
     */
    @Override
    public void keyTyped(KeyEvent e) {}

    /**
     * Updates the controller with a new player.
     *
     * @param basePlayer the new player to control with the keyboard
     */
    public void updatePlayer(BasePlayer basePlayer){
        this.basePlayer = basePlayer;
    }

    /**
     * Sets the Space Player Collision field.
     *
     * @param spc sets the Space PlayerCollisions field
     */
    public void setSpc(SpacePlayerCollisions spc) {
        this.spc = spc;
    }

    /**
     * Checks if the player is currently facing left.
     *
     * @return true if facing left, false otherwise
     */
    public boolean isFacingLeft() {
        return facingLeft;
    }

    /**
     * Checks if the player is currently facing right.
     *
     * @return true if facing right, false otherwise
     */
    public boolean isFacingRight() {
        return facingRight;
    }
}