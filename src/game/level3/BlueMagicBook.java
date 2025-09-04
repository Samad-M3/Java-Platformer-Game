package game.level3;

import city.cs.engine.*;
import game.core.GameLevel;

/**
 * Represents a blue magic book collectible in Level 3 (Magic Theme).
 * The BlueMagicBook class is a dynamic body that the player can collect.
 */
public class BlueMagicBook extends DynamicBody {

    /**
     * The shape of the blue magic book.
     */
    private static final Shape maigcBookShape = new PolygonShape(-0.1f,0.94f, 0.98f,0.47f, 0.98f,0.05f, 0.18f,-0.94f, 0.0f,-0.94f, -1.18f,-0.18f, -1.18f,-0.02f);

    /**
     * The image representation of the blue magic book.
     */
    private static final BodyImage image = new BodyImage("data/magicTheme/magicBook2.png", 3f);

    /**
     * Constructs a BlueMagicBook object in the given world.
     *
     * @param world the world where the blue magic book will be placed
     */
    public BlueMagicBook(GameLevel world) {
        super(world, maigcBookShape);
        this.addImage(image);
        this.setGravityScale(0);
    }
}