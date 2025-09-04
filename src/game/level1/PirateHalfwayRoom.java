package game.level1;

import city.cs.engine.*;
import city.cs.engine.Shape;
import game.core.GameLevel;
import org.jbox2d.common.Vec2;
import java.awt.*;

/**
 * The PirateHalfwayRoom class represents a room in the game, featuring a floor, walls, and roofs and a tiny
 * area to hide in away from the enemy pirate.
 */
public class PirateHalfwayRoom {

    /**
     * Constructs a PirateHalfwayRoom object in the specified game world.
     * The room is made up of several static bodies such as a floor, walls, and roofs.
     *
     * @param world the world where the hideaway room will be placed
     */
    public PirateHalfwayRoom(GameLevel world) {
        Shape floorShape = new BoxShape(9.5f, 0.3f);
        StaticBody floor = new StaticBody(world, floorShape);
        floor.setPosition(new Vec2(0f, 40f));
        floor.setFillColor(new Color(160, 220, 204, 180));

        Shape WallShape = new BoxShape(0.3f, 2f);
        StaticBody roomLeftWall = new StaticBody(world, WallShape);
        StaticBody roomRightWall = new StaticBody(world, WallShape);
        roomLeftWall.setPosition(new Vec2(3.7f, 46f));
        roomRightWall.setPosition(new Vec2(-3.7f, 46f));
        roomLeftWall.setFillColor(new Color(160, 220, 204, 180));
        roomRightWall.setFillColor(new Color(160, 220, 204, 180));

        Shape roomRoofShape1 = new BoxShape(6.75f, 0.3f);
        StaticBody roomRoof1 = new StaticBody(world, roomRoofShape1);
        roomRoof1.setPosition(new Vec2(-2.75f, 48.3f));
        roomRoof1.setFillColor(new Color(160, 220, 204, 180));

        Shape roomFloorShape1 = new BoxShape(0.5f, 0.3f);
        StaticBody roomFloor1 = new StaticBody(world, roomFloorShape1);
        roomFloor1.setPosition(new Vec2(0f, 44.3f));
        roomFloor1.setFillColor(new Color(160, 220, 204, 180));

        Shape roomFloorShape2 = new BoxShape(4.25f, 0.3f);
        StaticBody roomFloor2 = new StaticBody(world, roomFloorShape2);
        roomFloor2.setPosition(new Vec2(8.25f, 44.3f));
        roomFloor2.setFillColor(new Color(160, 220, 204, 180));

        Shape roomFloorShape3 = new BoxShape(2.75f, 0.3f);
        StaticBody roomFloor3 = new StaticBody(world, roomFloorShape3);
        roomFloor3.setPosition(new Vec2(-6.75f, 44.3f));
        roomFloor3.setFillColor(new Color(160, 220, 204, 180));

        Shape roomRoofShape2 = new BoxShape(2.75f, 0.3f);
        StaticBody roomRoof2 = new StaticBody(world, roomRoofShape2);
        roomRoof2.setPosition(new Vec2(9.75f, 48.3f));
        roomRoof2.setFillColor(new Color(160, 220, 204, 180));
    }
}