package game.level1;

import city.cs.engine.*;
import game.core.GameLevel;

/**
 * Represents a treasure chest in Level 1.
 * The TreasureChest class is a dynamic body that can be interacted with by the player.
 */
public class TreasureChest extends DynamicBody {

    /**
     * The shape of the treasure chest.
     */
    private static final Shape treasureChestShape = new BoxShape(1.5f, 1.4f);

    /**
     * The image of the treasure chest.
     */
    private static final BodyImage image = new BodyImage("data/pirateTheme/chest.png", 3f);

    /**
     * Constructs a TreasureChest object in the given world.
     *
     * @param world the world where the treasure chest will be placed.
     */
    public TreasureChest(GameLevel world) {
        super(world, treasureChestShape);
        addImage(image);
        setGravityScale(0);
    }
}