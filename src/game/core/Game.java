package game.core;

import game.level1.Level1;
import game.level2.Level2;
import game.level3.Level3;
import org.jbox2d.common.Vec2;
import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Manages the switching between levels, sets up the first level, the view, the game window,
 * controller to allow the player to move, adds the camera tracker to track the player.
 */
public class Game {

    /**
     * The current level that the game is on.
     */
    private GameLevel currentLevel;

    /**
     * A view so we can actually see what is going on in the world.
     */
    private GameView view;

    /**
     * Controller to allow the player to move around.
     */
    private PlayerController controller;

    /**
     * Responsible for the actual window of our game and GUI.
     */
    private GameWindow gameWindow;

    /**
     * Used for the GUI to select which level to start from.
     */
    private int selectedLevel = 1;

    /**
     * Constructor creates the entire game.
     */
    public Game() {

        currentLevel = new Level1(this); // Set the first level

        view = new GameView(currentLevel, 500, 500, currentLevel.getPlayer()); // Set the view

        gameWindow = new GameWindow(view, currentLevel); // Set the game window

        controller = new PlayerController(currentLevel.getPlayer(), gameWindow); // Set the controls
        view.addKeyListener(controller); // Adds a key listener to the view to listen for keyboard inputs

        view.addMouseListener(new GiveFocus()); // Adds a mouse listener to the view to handle focus events

        CameraTracker cameraTracker = new CameraTracker(currentLevel.getPlayer(), view);
        currentLevel.addStepListener(cameraTracker);

        currentLevel.start();

        view.requestFocus(); // Requests focus for the view, making it ready for user input
    }

    /**
     * When called it correctly sets everything ready for the next level of the game to begin, such as
     * stopping the current level so it doesn't play in the background using up unnecessary resources,
     * stopping the current background track, setting the new background track, setting the world, the view,
     * the player, updating the controls so it matches the requirements needed for that level, setting up
     * the camera to follow the player and starting the level.
     */
    public void goToNextLevel() {
        if (currentLevel instanceof Level1) {
            currentLevel.stop(); // Stop the simulation running

            SoundManager.stop(gameWindow.getCurrentBackgroundTrack()); // Stop the current track
            gameWindow.setCurrentBackgroundTrack("spaceBackgroundTrack"); // Set the new track

            // Setting for enabling sound or not via the GUI
            if (gameWindow.getSoundEnabled()) {
                SoundManager.loop(gameWindow.getCurrentBackgroundTrack());
            }

            currentLevel = new Level2(this); // Set the second level
            view.setWorld(currentLevel); // Change the view
            view.setPlayer(currentLevel.getPlayer()); // Update the player for the view for HUD purposes
            view.setCentre(new Vec2(0, 0));
            controller.updatePlayer(currentLevel.getPlayer()); // Update the controls for the player
            controller.setSpc(((Level2) currentLevel).getSpacePlayerCollisions()); // Used to activate gravity boots when collected in game
            CameraTracker cameraTracker = new CameraTracker(currentLevel.getPlayer(), view);
            currentLevel.addStepListener(cameraTracker); // Add a step listener to track physics steps in the world
            currentLevel.start();
        }
        else if (currentLevel instanceof Level2) {
            currentLevel.stop(); // Stop the simulation running

            SoundManager.stop(gameWindow.getCurrentBackgroundTrack()); // Stop the current track
            gameWindow.setCurrentBackgroundTrack("magicBackgroundTrack"); // Set the new track

            // Setting for enabling sound or not via the GUI
            if (gameWindow.getSoundEnabled()) {
                SoundManager.loop(gameWindow.getCurrentBackgroundTrack());
            }

            currentLevel = new Level3(this, view); // Set the third level
            view.setWorld(currentLevel); // Change the view
            view.setPlayer(currentLevel.getPlayer()); // Update the player for the view for HUD purposes
            view.setCentre(new Vec2(0, 0));
            controller.updatePlayer(currentLevel.getPlayer()); // Update the controls for the player
            CameraTracker cameraTracker = new CameraTracker(currentLevel.getPlayer(), view);
            currentLevel.addStepListener(cameraTracker); // Add a step listener to track physics steps in the world
            currentLevel.start();
        }
        else if (currentLevel instanceof Level3) {
            SoundManager.stop(gameWindow.getCurrentBackgroundTrack()); // Stop the current track

            // After 30 seconds close the game
            Timer timer = new Timer(30000, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.exit(0);
                }
            });
            timer.setRepeats(false);
            timer.start();
        }
    }

    /**
     * Getter method allows the reference to the Player Controller object to be used elsewhere.
     *
     * @return the reference of the Player Controller object
     */
    public PlayerController getController() {
        return controller;
    }

    /**
     * Setter method allows the player to choose which level they want to start from.
     *
     * @param selectedLevel the level to start playing from
     */
    public void setSelectedLevel(int selectedLevel) {
        this.selectedLevel = selectedLevel;
    }

    /**
     * Getter method to return back the chosen level.
     *
     * @return the number of which level to start at, so level 1 (default), level 2 or level 3
     */
    public int getSelectedLevel() {
        return selectedLevel;
    }

    /**
     * Getter method that allows the reference to the GameLevel object to be used elsewhere.
     *
     * @return the reference of the Game Level object
     */
    public GameLevel getCurrentLevel() {
        return currentLevel;
    }

    /**
     * The entry point of the program.
     * This method starts the execution of the game.
     *
     * @param args the command-line arguments (not used in this case)
     */
    public static void main(String[] args) {
        new Game();
    }
}