package game.level2;

import city.cs.engine.*;
import game.core.GameLevel;

/**
 * The GravityBoots class represents a collectible item in the Space theme level.
 * It is a special collectible that can alter the player's movement properties, meaning it can jump higher.
 */
public class GravityBoots extends DynamicBody {

    /**
     * The shape used for the gravity boots.
     */
    private static final Shape gravityBootsShape = new PolygonShape(-0.62f,0.87f, 0.1f,0.97f, 0.58f,0.74f, 0.91f,-0.74f, -0.13f,-0.92f, -0.8f,-0.69f, -0.72f,0.82f);

    /**
     * The image representing the gravity boots.
     */
    private static final BodyImage image = new BodyImage("data/spaceTheme/gravityBoots.png", 3f);

    /**
     * Constructs a new GravityBoots object in the specified game world.
     * The gravity boots are represented by a shape and an image, and gravity is disabled for them.
     *
     * @param world the world where the gravity boots will exist and interact with other objects.
     */
    public GravityBoots(GameLevel world) {
        super(world, gravityBootsShape);
        this.addImage(image);
        this.setGravityScale(0);
    }
}