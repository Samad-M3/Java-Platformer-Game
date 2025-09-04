package game.level1;

import city.cs.engine.*;
import city.cs.engine.Shape;
import game.core.GameLevel;
import org.jbox2d.common.Vec2;
import java.awt.*;

/**
 * The PirateFinalRoom class represents the final room in the pirate level, where the player has jump over
 * an enemy to make contact with the flag and progress to the next level.
 */
public class PirateFinalRoom {

    /**
     * Constructs the PirateFinalRoom in the specified world, by setting the static bodies in a fixed arrangement
     * and sets these bodies to a yellow colour.
     *
     * @param world the world where said static bodies will be placed in
     */
    public PirateFinalRoom(GameLevel world) {
        Shape endRoofShape = new BoxShape(12.5f, 0.3f);
        StaticBody endRoof = new StaticBody(world, endRoofShape);
        endRoof.setPosition(new Vec2(0f, 135f));
        endRoof.setFillColor(new Color(234, 185, 23, 180));

        Shape endLeftFloorShape = new BoxShape(10.25f, 0.3f);
        StaticBody endLeftFloor = new StaticBody(world, endLeftFloorShape);
        endLeftFloor.setPosition(new Vec2(-2.25f, 128f));
        endLeftFloor.setFillColor(new Color(234, 185, 23, 180));

        Shape endRightFloorShape = new BoxShape(0.75f, 0.3f);
        StaticBody endRightFloor = new StaticBody(world, endRightFloorShape);
        endRightFloor.setPosition(new Vec2(11.75f, 128f));
        endRightFloor.setFillColor(new Color(234, 185, 23, 180));
    }
}