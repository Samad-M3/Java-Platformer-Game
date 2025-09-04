package game.core;

import city.cs.engine.*;

/**
 * Base class for all levels.
 */
public class GameLevel extends World {

    /**
     * The game instance that this level is associated with.
     */
    private Game game;

    /**
     * The player instance that this level is associated with
     */
    private BasePlayer basePlayer;

    /**
     * Constructs a new GameLevel instance associated with the given game.
     * This constructor also initialises the level with a frame rate of 60.
     *
     * @param game the game instance that this level will belong to
     */
    public GameLevel(Game game) {
        super(60);
        this.game = game;
    }

    /**
     * Sets the player for this level.
     *
     * @param basePlayer the player instance to be assigned to this object's player field
     */
    public void setPlayer(BasePlayer basePlayer) {
        this.basePlayer = basePlayer;
    }

    /**
     * Retrieves the player associated with this object.
     *
     * @return the current player instance
     */
    public BasePlayer getPlayer() {
        return basePlayer;
    }

    /**
     * Retrieves the game associated with this object.
     *
     * @return the current game instance
     */
    public Game getGame() {
        return game;
    }
}