package game.level1;

import city.cs.engine.*;
import game.core.GameLevel;

/**
 * Represents a spike obstacle in Level 1.
 * The Spike class is a static body that can cause damage to the player if they collide with it.
 */
public class Spike extends StaticBody {

    /**
     * The shape of the spike.
     */
    private static final Shape spikeShape = new PolygonShape(-1.268f,0.495f, -0.952f,-0.447f, 0.937f,-0.447f, 1.248f,0.495f, -1.222f,0.5f);

    /**
     * The image of the spike.
     */
    private static final BodyImage image = new BodyImage("data/pirateTheme/spikes.png", 1f);

    /**
     * Constructs a Spike object in the given world.
     *
     * @param world the world where the spike will be placed
     */
    public Spike(GameLevel world) {
        super(world, spikeShape);
        this.addImage(image);
    }
}