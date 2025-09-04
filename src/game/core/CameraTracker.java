package game.core;

import city.cs.engine.StepEvent;
import city.cs.engine.StepListener;
import org.jbox2d.common.Vec2;

/**
 * A camera that tracks the player as it progresses higher and higher in the game.
 */
public class CameraTracker implements StepListener {

    /**
     * The player that the camera follows.
     */
    private final BasePlayer basePlayer;

    /**
     * The view that the camera belongs to.
     */
    private final GameView view;

    /**
     * Create a camera tracker to follow the player.
     *
     * @param basePlayer the player to track
     * @param view the view that the camera tracker belongs to
     */
    public CameraTracker(BasePlayer basePlayer, GameView view) {
        this.basePlayer = basePlayer;
        this.view = view;
    }

    /**
     * Called before each simulation step.
     *
     * @param stepEvent the event containing information about the current step
     */
    @Override
    public void preStep(StepEvent stepEvent) {}

    /**
     * Called after each simulation step.
     *
     * Store the y-position of the character in a variable. The camera threshold is 5f meaning once the
     * player passes this y-level, this is when the camera starts to follow the player. The smooth factor is
     * responsible for ensuring a smooth transition from y-level of 0 (initial camera level) to whatever the
     * y-level of the player is.
     *
     * @param stepEvent the event containing information about the current step
     */
    @Override
    public void postStep(StepEvent stepEvent) {
        float yPosCharacter = basePlayer.getPosition().y;
        float cameraThreshold = 5f;
        float smoothFactor = 0.05f;

        // The camera smoothly transitions to y-level 0 when the players y-position is
        // less than the camera threshold (5f) using linear interpolation
        if (yPosCharacter < cameraThreshold) {
            float yPosCurrent = view.getCentre().y;
            float yPosNew = yPosCurrent + (0 - yPosCurrent) * smoothFactor;
            view.setCentre(new Vec2(0, yPosNew));
        }

        // The camera smoothly starts to follow the player after they have surpassed the threshold level
        // using linear interpolation
        else if (yPosCharacter > cameraThreshold) {
            float yPosCurrent = view.getCentre().y;
            float yPosNew = yPosCurrent + (yPosCharacter - yPosCurrent) * smoothFactor;
            view.setCentre(new Vec2(0, yPosNew));
        }
    }
}