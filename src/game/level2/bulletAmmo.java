package game.level2;

import city.cs.engine.*;
import game.core.GameLevel;

/**
 * The bulletAmmo class represents an ammunition item in level 2.
 * It extends from DynamicBody and defines the shape and image for the ammo as well as the behavior for gravity.
 */
public class bulletAmmo extends DynamicBody {

    /**
     * Shape representing the ammo.
     */
    private static final Shape ammoShape = new BoxShape(1f, 0.6f);

    /**
     * Image representing the ammo.
     */
    private static final BodyImage image = new BodyImage("data/spaceTheme/ammo.png", 1.5f);

    /**
     * Constructs a new bulletAmmo in the specified game world.
     * The ammo is initialised with a shape and image and set to have no gravity, meaning to make it
     * appear like its floating.
     *
     * @param world the world where the ammo will exist and interact with other objects.
     */
    public bulletAmmo(GameLevel world) {
        super(world, ammoShape);
        this.addImage(image);
        this.setGravityScale(0);
    }
}