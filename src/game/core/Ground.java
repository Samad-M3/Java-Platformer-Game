package game.core;

import city.cs.engine.*;
import java.awt.Color;

/**
 * Responsible for creating the ground in a level.
 */
public class Ground extends StaticBody {

    /**
     * The shape of the ground.
     */
    private static final Shape groundShape = new BoxShape(12.5f, 0.5f);

    /**
     * Constructor sets up the Ground object and sets it to a washed blue colour.
     *
     * @param world the world the ground belongs to
     */
    public Ground(GameLevel world) {
        super(world, groundShape);
        this.setFillColor(new Color(160, 220, 204, 180));
    }
}