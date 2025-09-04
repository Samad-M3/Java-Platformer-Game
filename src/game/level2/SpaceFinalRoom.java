package game.level2;

import city.cs.engine.*;
import city.cs.engine.Shape;
import game.core.GameLevel;
import org.jbox2d.common.Vec2;
import java.awt.*;

/**
 * The SpaceFinalRoom class represents the final room in the Space theme level of the game.
 * It consists of platforms, walls, and the floor, which together form the environment for the player.
 */
public class SpaceFinalRoom {

    /**
     * Constructs a SpaceFinalRoom in the specified world.
     * This method creates the platforms, walls, and floor of the final room.
     *
     * @param world the world in which the final room exists
     */
    public SpaceFinalRoom(GameLevel world) {

        Shape topPlatformShape = new BoxShape(4f, 0.3f);
        StaticBody topRightPlatformBody = new StaticBody(world, topPlatformShape);
        topRightPlatformBody.setPosition(new Vec2(5.5f, 161.3f));
        topRightPlatformBody.setFillColor(new Color(11, 46, 81, 180));

        StaticBody topLeftPlatformBody = new StaticBody(world, topPlatformShape);
        topLeftPlatformBody.setPosition(new Vec2(-5.5f, 161.3f));
        topLeftPlatformBody.setFillColor(new Color(11, 46, 81, 180));

        Shape finalRoomWallShape = new BoxShape(0.25f, 6.25f);
        StaticBody finalRoomLeftWallBody = new StaticBody(world, finalRoomWallShape);
        finalRoomLeftWallBody.setPosition(new Vec2(-9.25f, 154.8f));
        finalRoomLeftWallBody.setFillColor(new Color(11, 46, 81, 180));

        StaticBody finalRoomRightWallBody = new StaticBody(world, finalRoomWallShape);
        finalRoomRightWallBody.setPosition(new Vec2(9.25f, 154.8f));
        finalRoomRightWallBody.setFillColor(new Color(11, 46, 81, 180));

        Shape finalRoomFloorShape = new BoxShape(9.5f, 0.3f);
        StaticBody finalRoomFloorBody = new StaticBody(world, finalRoomFloorShape);
        finalRoomFloorBody.setPosition(new Vec2(0f, 148.25f));
        finalRoomFloorBody.setFillColor(new Color(11, 46, 81, 180));
    }
}