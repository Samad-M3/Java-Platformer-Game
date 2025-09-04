package game.level1;

import city.cs.engine.*;
import game.core.GameLevel;
import java.awt.Color;

/**
 * Represents a wall in Level 1.
 * The wall serves as an impassable barrier for the player.
 */
public class Wall extends StaticBody {

    /**
     * The shape of the wall.
     */
    private static final Shape gameWall = new BoxShape(0.25f, 73f);

    /**
     * Constructs a Wall object in the given world.
     *
     * @param world the world where the wall will be placed
     */
    public Wall(GameLevel world) {
        super(world, gameWall);
        this.setFillColor(new Color(160, 220, 204, 180));
    }
}