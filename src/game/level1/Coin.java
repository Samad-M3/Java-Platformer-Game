package game.level1;

import city.cs.engine.*;
import game.core.GameLevel;

/**
 * The Coin class represents a collectible coin object in the game.
 */
public class Coin extends DynamicBody {

    /**
     * Shape of coin.
     */
    private static final Shape coinShape = new CircleShape(0.8f);

    /**
     * Image of the coin.
     */
    private static final BodyImage image = new BodyImage("data/pirateTheme/coin.png", 3f);

    /**
     * Constructs a coin object and adds it to the given world.
     * The gravity scale is set to 0 to create the illusion that it is floating.
     *
     * @param world the world in which the coin will be placed in
     */
    public Coin(GameLevel world) {
        super(world, coinShape);
        this.addImage(image);
        this.setGravityScale(0);
    }
}