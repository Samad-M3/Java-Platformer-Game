package game.level3;

import city.cs.engine.*;
import game.core.GameLevel;

/**
 * Represents a magic potion in the game. This potion is a dynamic body that is harmful
 */
public class MagicPotion extends DynamicBody {

    /**
     * The shape of the potion.
     */
    private static final Shape potionShape = new PolygonShape(-0.18f,1.28f, 0.17f,1.28f, 0.73f,-0.31f, 0.73f,-0.83f, 0.22f,-1.24f, -0.18f,-1.24f, -0.74f,-0.76f, -0.74f,-0.32f);

    /**
     * The image displayed for the potion.
     */
    private static final BodyImage image = new BodyImage("data/magicTheme/fieryPotion.png", 3f);

    /**
     * Creates a new MagicPotion.
     * The potion gravity scale is set to 0, to show that it is floating
     *
     * @param world the world that the potion will be a part of
     */
    public MagicPotion(GameLevel world) {
        super(world, potionShape);
        this.addImage(image);
        this.setGravityScale(0);
    }
}