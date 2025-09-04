package game.level2;

import city.cs.engine.*;
import city.cs.engine.Shape;
import game.core.Trampoline;
import game.core.GameLevel;
import org.jbox2d.common.Vec2;
import java.awt.*;

/**
 * The SpaceHalfWayRoom class represents a section of the Space-themed level.
 * It creates various floors, blocks, and a trampoline to provide structure and interaction
 * within this part of the world.
 */
public class SpaceHalfwayRoom {

    /**
     * Constructs a SpaceHalfwayRoom in the specified world.
     * This method creates the platforms, walls, and floor of the SpaceHalfwayRoom.
     *
     * @param world the world in which the SpaceHalfwayRoom exists
     */
    public SpaceHalfwayRoom(GameLevel world) {
        Shape firstFloorShape = new BoxShape(5.5f, 0.3f);
        StaticBody rightFirstFloorBody = new StaticBody(world, firstFloorShape);
        rightFirstFloorBody.setPosition(new Vec2(7f, 49.75f));
        rightFirstFloorBody.setFillColor(new Color(11, 46, 81, 180));

        StaticBody leftFirstFloorBody = new StaticBody(world, firstFloorShape);
        leftFirstFloorBody.setPosition(new Vec2(-7f, 49.75f));
        leftFirstFloorBody.setFillColor(new Color(11, 46, 81, 180));

        Shape secondFloorShape = new BoxShape(10.75f, 0.3f);
        StaticBody secondFloorBody = new StaticBody(world, secondFloorShape);
        secondFloorBody.setPosition(new Vec2(-1.75f, 54.75f));
        secondFloorBody.setFillColor(new Color(11, 46, 81, 180));

        Shape verticalBlock = new BoxShape(0.25f, 6.5f);
        StaticBody verticalBlockBody1 = new StaticBody(world, verticalBlock);
        verticalBlockBody1.setPosition(new Vec2(8.75f, 61.5f));
        verticalBlockBody1.setFillColor(new Color(11, 46, 81, 180));

        StaticBody verticalBlockBody2 = new StaticBody(world, verticalBlock);
        verticalBlockBody2.setPosition(new Vec2(-3.75f, 61.5f));
        verticalBlockBody2.setFillColor(new Color(11, 46, 81, 180));

        Shape thirdFloorShape = new BoxShape(2f, 0.3f);
        StaticBody thirdFloorBody = new StaticBody(world, thirdFloorShape);
        thirdFloorBody.setPosition(new Vec2(2.5f, 59.55f));
        thirdFloorBody.setFillColor(new Color(11, 46, 81, 180));

        Shape leftFourthFloorShape = new BoxShape(4.75f, 0.3f);
        StaticBody leftFourthFloorBody = new StaticBody(world, leftFourthFloorShape);
        leftFourthFloorBody.setPosition(new Vec2(-4.25f, 72.5f));
        leftFourthFloorBody.setFillColor(new Color(11, 46, 81, 180));

        Shape rightFourthFloorShape = new BoxShape(4f, 0.3f);
        StaticBody rightFourthFloorBody = new StaticBody(world, rightFourthFloorShape);
        rightFourthFloorBody.setPosition(new Vec2(8.5f, 72.5f));
        rightFourthFloorBody.setFillColor(new Color(11, 46, 81, 180));

        StaticBody verticalBlockBody3 = new StaticBody(world, verticalBlock);
        verticalBlockBody3.setPosition(new Vec2(0.25f, 65.75f));
        verticalBlockBody3.setFillColor(new Color(11, 46, 81, 180));

        StaticBody verticalBlockBody4 = new StaticBody(world, verticalBlock);
        verticalBlockBody4.setPosition(new Vec2(4.75f, 65.75f));
        verticalBlockBody4.setFillColor(new Color(11, 46, 81, 180));

        StaticBody verticalBlockBody5 = new StaticBody(world, verticalBlock);
        verticalBlockBody5.setPosition(new Vec2(-8.75f, 65.75f));
        verticalBlockBody5.setFillColor(new Color(11, 46, 81, 180));

        Trampoline trampoline = new Trampoline(world, new Vec2(2.5f, 60.25f));

        Shape leftFifthFloorShape = new BoxShape(10.5f, 0.3f);
        StaticBody leftFifthFloorBody = new StaticBody(world, leftFifthFloorShape);
        leftFifthFloorBody.setPosition(new Vec2(-2f, 77f));
        leftFifthFloorBody.setFillColor(new Color(11, 46, 81, 180));
    }
}