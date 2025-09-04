package game.level3;

import city.cs.engine.*;
import game.core.GameLevel;

/**
 * Represents a pink magic book in the game. This book is a collectible item
 */
public class PinkMagicBook extends DynamicBody {

    /**
     * The shape of the magic book.
     */
    private static final Shape maigcBookShape = new PolygonShape(-0.55f,1.0f, 0.63f,1.0f, 0.95f,0.77f, 0.64f,-0.96f, -0.73f,-0.91f, -0.96f,-0.73f, -0.73f,0.64f);

    /**
     * The image displayed for the magic book.
     */
    private static final BodyImage image = new BodyImage("data/magicTheme/magicBook1.png", 3f);

    /**
     * Creates a new PinkMagicBook.
     *
     * @param world the world that the magic book will be part of
     */
    public PinkMagicBook(GameLevel world) {
        super(world, maigcBookShape);
        this.addImage(image);
        this.setGravityScale(0);
    }
}