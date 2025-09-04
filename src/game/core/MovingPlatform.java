package game.core;

import city.cs.engine.*;
import city.cs.engine.Shape;
import org.jbox2d.common.Vec2;
import java.awt.Color;

/**
 * A platform that moves vertically by a specified amount.
 */
public class MovingPlatform extends StaticBody implements StepListener {

    /**
     * The shape of the vertically moving platform.
     */
    private static final Shape shape = new BoxShape(1.5f, 0.3f);

    /**
     * The point in which the platform has reached its minimum level and moves back up.
     */
    private float min;

    /**
     * The point in which the platform has reached its maximum level and moves back down.
     */
    private float max;

    /**
     * How much in terms of the y-level to redraw the moving platform by.
     */
    private float reposition;


    /**
     * Creates a moving platform at a specified position and sets how high it should move vertically.
     *
     * @param world the world the moving platform belongs to
     * @param startingPosition where in the world should the moving platform be positioned
     * @param height how high should the moving platform travel vertically
     */
    public MovingPlatform(GameLevel world, Vec2 startingPosition, float height) {
        super(world, shape);
        this.setPosition(startingPosition);
        this.min = startingPosition.y;
        this.max = startingPosition.y + height;
        this.reposition = 0.08f;
        this.setFillColor(new Color(129, 234, 108, 180));
        world.addStepListener(this);
    }

    /**
     * Called before each simulation step.
     *
     * Checks if the platform's y-position is below the minimum or above the maximum.
     * If so, reverses its movement direction by inverting the repositioning value.
     * Moves the platform vertically by the repositioning amount.
     *
     * @param stepEvent the event containing information about the current step
     */
    @Override
    public void preStep(StepEvent stepEvent) {
        if (this.getPosition().y < min) {
            reposition *= -1;
        }
        if (this.getPosition().y > max) {
            reposition *= -1;
        }
        this.setPosition(new Vec2(this.getPosition().x, this.getPosition().y + reposition));
    }

    /**
     * Called after each simulation step.
     *
     * @param stepEvent the event containing information about the current step
     */
    @Override
    public void postStep(StepEvent stepEvent) {}
}