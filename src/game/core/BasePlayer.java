package game.core;

import city.cs.engine.*;
import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Base class for all players.
 */
public class BasePlayer extends Walker {

    /**
     * The world that the player belongs to.
     */
    private final GameLevel world;

    /**
     * The number of lives that each player initially starts with.
     */
    private int lives;

    /**
     * Creates a player that belongs to a world, has a shape, and an image.
     *
     * @param world the world the player belongs to
     * @param playerShape the shape of the player
     * @param playerImage the image of the player
     */
    public BasePlayer(GameLevel world, Shape playerShape, BodyImage playerImage) {
        super(world, playerShape);
        this.world = world;
        this.addImage(playerImage);
        this.lives = 3;
    }

    /**
     * Setter method used to set the number of lives the player has.
     *
     * @param lives the number of lives to set the lives field to
     */
    public void setLives(int lives) {
        this.lives = lives;
    }

    /**
     * Getter method used to get the number of lives the player has.
     *
     * @return the number of lives
     */
    public int getLives() {
        return lives;
    }

    /**
     * When a player comes into contact with something harmful, reduces the player's lives by one.
     * If the player has no lives remaining, plays a defeat sound, stops the world, and exits the game after 5 seconds.
     */
    public void loseLives() {
        lives--;
        if (lives == 0) {
            SoundManager.play("defeat");
            world.stop();
            Timer timer = new Timer(5000, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.exit(0);
                }
            });
            timer.setRepeats(false);
            timer.start();
        }
    }

    /**
     * Returns the world that this player is currently in.
     *
     * @return the world that this player is in
     */
    public GameLevel getWorld() {
        return world;
    }
}