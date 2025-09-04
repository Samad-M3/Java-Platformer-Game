package game.level1;

import city.cs.engine.*;
import game.core.GameLevel;
import game.core.BasePlayer;

/**
 * The PiratePlayer class represents the player in the level 1.
 * It extends the BasePlayer class, inheriting common player functionality.
 * This class is responsible for handling the player's coin count and appearance in level 1.
 */
public class PiratePlayer extends BasePlayer {

    /**
     * Shape of the player.
     */
    private static final Shape leftPlayerShape = new PolygonShape(-0.2f,1.43f, 0.35f,1.44f, 0.9f,0.91f, 1.02f,-0.22f, 0.76f,-1.49f, -0.67f,-1.49f, -0.93f,-0.54f, -0.64f,0.92f);

    /**
     * Image of the player facing right.
     */
    private static final BodyImage rightPlayerImage = new BodyImage("data/pirateTheme/captain_flipped.png", 3f);

    /**
     * Total number of coins collected by the player.
     */
    private int totalCoins;

    /**
     * The constructor creates a PiratePlayer using the fields above, it also makes a call to its superclass
     * constructor which is responsible for the appearance of the PiratePlayer
     *
     * @param world the world to which the player belongs to
     */
    public PiratePlayer(GameLevel world) {
        super(world, leftPlayerShape, rightPlayerImage);
        this.totalCoins = 0;
    }

    /**
     * Sets the total number of coins the player has collected.
     *
     * @param coin the number of coins to set
     */    public void setCoins(int coin) {
        totalCoins = coin;
    }

    /**
     * Retrieves the total number of coins collected by the player.
     *
     * @return the number of coins collected by the player
     */
    public int getCoins() {
        return totalCoins;
    }
}