package game.core;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

/**
 * The Trampoline class represents a trampoline object in the game world.
 */
public class Trampoline {

    /**
     * Constructs a trampoline object and adds it to the given world at the specified position.
     * The trampoline has a unique shape, high restitution for bouncing effects,
     * and an image representing it in the game.
     *
     * @param world the world where the trampoline will be added
     * @param position the position where the trampoline will be placed in the world
     */
    public Trampoline(GameLevel world, Vec2 position) {
        // Defining the shape of the trampoline using a PolygonShape
        Shape trampolineShape = new PolygonShape(-0.78f,0.66f, -1.62f,0.38f, -1.5f,-0.48f, -0.52f,-0.67f, 0.5f,-0.66f, 1.46f,-0.46f, 1.6f,0.41f, 0.63f,0.67f);

        // Creating a static body for the trampoline in the world
        StaticBody trampolineBody = new StaticBody(world);

        // Adding the shape as a fixture to the body
        SolidFixture trampoline = new SolidFixture(trampolineBody, trampolineShape);

        // Setting the restitution (bounciness) of the trampoline
        trampoline.setRestitution(2f);

        // Setting the position of the trampoline based on the given Vec2 position
        trampolineBody.setPosition(new Vec2(position.x, position.y));

        // Adding an image to the trampoline body for visualisation
        trampolineBody.addImage(new BodyImage("data/pirateTheme/trampoline.png", 4f));
    }
}