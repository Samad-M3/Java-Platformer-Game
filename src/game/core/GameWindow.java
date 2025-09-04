package game.core;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * GameWindow is responsible for creating and managing the graphical user interface (GUI) of the game.
 * This includes setting up the JFrame, handling user input, and displaying game-related information.
 */
public class GameWindow {

    /**
     * The GameView instance used for rendering the game world.
     */
    private GameView view;

    /**
     * The GameLevel instance representing the current level of the game.
     */
    private GameLevel world;

    /**
     * The JFrame that contains the entire game window.
     */
    private final JFrame frame;

    /**
     * The JPanel that holds the main menu interface.
     */
    private final JPanel menuPanel;

    /**
     * The JPanel that contains the level selection options.
     */
    private final JPanel levelSelectionPanel;

    /**
     * The JPanel that displays instructions for the game.
     */
    private final JPanel instructionPanel;

    /**
     * The JPanel that displays the pause menu when the game is paused.
     */
    private JPanel pauseMenuPanel;

    /**
     * The JPanel that is combined with the instruction panel to allow the back button and title
     * to be on the same line.
     */
    private JPanel topPanel;

    /**
     * The JButton used to navigate back from the instruction panel to the main menu panel.
     */
    private JButton backButton;

    /**
     * A flag indicating whether the background track should be enabled or not which can be changed
     * in the pause menu.
     */
    private boolean soundEnabled = true;

    /**
     * The current background track playing in the game.
     */
    private String currentBackgroundTrack;

    /**
     * Constructs a new GameWindow, initializes the graphical user interface (GUI) components,
     * and sets up the initial game menu. This includes setting up panels for the menu,
     * level selection, instructions, and pause menu. It also configures action listeners
     * for buttons like Play, Level Selection, Instructions, and Quit.
     *
     * @param view the GameView instance representing the view for the game world
     * @param world the GameLevel instance representing the current level of the game
     */
    public GameWindow(GameView view, GameLevel world) {
        this.view = view;
        this.world = world;

        frame = new JFrame("Game");

        menuPanel = new JPanel(); // Create the menu panel
        menuPanel.setLayout(new BoxLayout(menuPanel, BoxLayout.Y_AXIS)); // Set its button layout for this panel to be vertical
        menuPanel.setBackground(Color.decode("#87CEEB"));

        levelSelectionPanel = new JPanel(); // Create the level selection panel
        levelSelectionPanel.setLayout(new BoxLayout(levelSelectionPanel, BoxLayout.Y_AXIS)); // Set its button layout for this panel to be vertical

        instructionPanel = new JPanel(); // Create the instruction panel
        instructionPanel.setLayout(new BoxLayout(instructionPanel, BoxLayout.Y_AXIS));

        pauseMenuPanel = new JPanel(); // Create the pause menu panel
        pauseMenuPanel.setLayout(new BoxLayout(pauseMenuPanel, BoxLayout.Y_AXIS)); // Set its button layout for this panel to be vertical
        pauseMenuPanel.setBackground(Color.decode("#87CEEB"));

        JLabel gameTitle = new JLabel("Platform Jumper"); // Set the title of the GUI
        gameTitle.setFont(new Font("Monospaced", Font.BOLD, 40));
        gameTitle.setForeground(Color.decode("#1C1C1C"));

        JButton playButton = new JButton("Play");
        playButton.setFont(new Font("Monospaced", Font.BOLD, 15));
        playButton.setBackground(Color.decode("#FFA500"));
        playButton.setForeground(Color.decode("#FFFFFF"));
        playButton.setFocusPainted(false); // Removes focus border
        playButton.setMaximumSize(new Dimension(160, 35));
        playButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (world.getGame().getSelectedLevel() == 1) {
                    currentBackgroundTrack = "pirateBackgroundTrack";
                    SoundManager.loop(currentBackgroundTrack);
                }
                else if (world.getGame().getSelectedLevel() == 2) {
                    world.getGame().goToNextLevel(); // Make a call to goToNextLevel() method to start at level 2
                }
                else if (world.getGame().getSelectedLevel() == 3) {
                    world.getGame().goToNextLevel();
                    world.getGame().goToNextLevel(); // Make a call to goToNextLevel() twice to start at level 3
                }
                frame.remove(menuPanel);
                frame.add(view);
                frame.revalidate();  // Revalidate layout after adding view
                frame.repaint();  // Repaint to display view
                frame.pack(); // Ensuring that everything inside the frame is visible and correctly laid out
            }
        });

        JButton levelSelectionButton = new JButton("Select Level");
        levelSelectionButton.setFont(new Font("Monospaced", Font.BOLD, 15));
        levelSelectionButton.setBackground(Color.decode("#FFA500"));
        levelSelectionButton.setForeground(Color.decode("#FFFFFF"));
        levelSelectionButton.setFocusPainted(false); // Removes focus border
        levelSelectionButton.setMaximumSize(new Dimension(160, 35));
        levelSelectionButton.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               levelSelectionPanel.removeAll();
               levelSelectionPanel.setBackground(Color.decode("#87CEEB"));

               JButton level1 = new JButton("Level 1");
               level1.setFont(new Font("Monospaced", Font.BOLD, 15));
               level1.setBackground(Color.decode("#FFA500"));
               level1.setForeground(Color.decode("#FFFFFF"));
               level1.setFocusPainted(false); // Removes focus border
               level1.setMaximumSize(new Dimension(150, 35));
               level1.addActionListener(new ActionListener() {
                   @Override
                   public void actionPerformed(ActionEvent e) {
                       world.getGame().setSelectedLevel(1);
                       frame.remove(levelSelectionPanel);
                       frame.add(menuPanel);
                       frame.revalidate(); // Revalidate layout after adding menuPanel
                       frame.repaint(); // Repaint to display menuPanel
                   }
               });

               JButton level2 = new JButton("Level 2");
               level2.setFont(new Font("Monospaced", Font.BOLD, 15));
               level2.setBackground(Color.decode("#FFA500"));
               level2.setForeground(Color.decode("#FFFFFF"));
               level2.setFocusPainted(false); // Removes focus border
               level2.setMaximumSize(new Dimension(150, 35));
               level2.addActionListener(new ActionListener() {
                   @Override
                   public void actionPerformed(ActionEvent e) {
                       world.getGame().setSelectedLevel(2);
                       frame.remove(levelSelectionPanel);
                       frame.add(menuPanel);
                       frame.revalidate(); // Revalidate layout after adding menuPanel
                       frame.repaint(); // Repaint to display menuPanel
                   }
               });

               JButton level3 = new JButton("Level 3");
               level3.setFont(new Font("Monospaced", Font.BOLD, 15));
               level3.setBackground(Color.decode("#FFA500"));
               level3.setForeground(Color.decode("#FFFFFF"));
               level3.setFocusPainted(false); // Removes focus border
               level3.setMaximumSize(new Dimension(150, 35));
               level3.addActionListener(new ActionListener() {
                   @Override
                   public void actionPerformed(ActionEvent e) {
                       world.getGame().setSelectedLevel(3);
                       frame.remove(levelSelectionPanel);
                       frame.add(menuPanel);
                       frame.revalidate(); // Revalidate layout after adding menuPanel
                       frame.repaint(); // Repaint to display menuPanel
                   }
               });

               levelSelectionPanel.add(Box.createVerticalStrut(120));
               levelSelectionPanel.add(level1);
               levelSelectionPanel.add(Box.createVerticalStrut(40));
               levelSelectionPanel.add(level2);
               levelSelectionPanel.add(Box.createVerticalStrut(40));
               levelSelectionPanel.add(level3);

               level1.setAlignmentX(Component.CENTER_ALIGNMENT);
               level2.setAlignmentX(Component.CENTER_ALIGNMENT);
               level3.setAlignmentX(Component.CENTER_ALIGNMENT);

               frame.remove(menuPanel);
               frame.add(levelSelectionPanel);
               frame.revalidate();  // Revalidate layout after adding levelSelectionPanel
               frame.repaint();  // Repaint to display levelSelectionPanel
           }
        });

        JButton instructionButton = new JButton("Instructions");
        instructionButton.setFont(new Font("Monospaced", Font.BOLD, 15));
        instructionButton.setBackground(Color.decode("#FFA500"));
        instructionButton.setForeground(Color.decode("#FFFFFF"));
        instructionButton.setFocusPainted(false); // Removes focus border
        instructionButton.setMaximumSize(new Dimension(160, 35));
        instructionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createInstructionsPage();
            }
        });

        JButton quitButton = new JButton("Quit");
        quitButton.setFont(new Font("Monospaced", Font.BOLD, 15));
        quitButton.setBackground(Color.decode("#FFA500"));
        quitButton.setForeground(Color.decode("#FFFFFF"));
        quitButton.setFocusPainted(false); // Removes focus border
        quitButton.setMaximumSize(new Dimension(160, 35));
        quitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        menuPanel.add(Box.createVerticalStrut(50));
        menuPanel.add(gameTitle);
        menuPanel.add(Box.createVerticalStrut(50));
        menuPanel.add(playButton);
        menuPanel.add(Box.createVerticalStrut(10));
        menuPanel.add(levelSelectionButton);
        menuPanel.add(Box.createVerticalStrut(10));
        menuPanel.add(instructionButton);
        menuPanel.add(Box.createVerticalStrut(10));
        menuPanel.add(quitButton);

        gameTitle.setAlignmentX(Component.CENTER_ALIGNMENT);
        playButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        levelSelectionButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        instructionButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        quitButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        frame.add(menuPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationByPlatform(true);
        frame.setResizable(false);
        frame.setSize(512, 535);
        frame.setVisible(true);
    }

    /**
     * Creates the instructions page of the game, displaying essential information such as game objectives,
     * controls, gameplay features, and final words. This method builds and displays the entire instructions
     * page with various sections and a back button to navigate back to the menu.
     */
    public void createInstructionsPage() {
        instructionPanel.removeAll();
        instructionPanel.setBackground(Color.decode("#87CEEB"));

        topPanel = new JPanel(); // Create the top panel
        topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.X_AXIS)); // Set its button layout for this panel to be horizontal

        backButton = new JButton("Back");
        backButton.setFont(new Font("Monospaced", Font.BOLD, 10));
        backButton.setBackground(Color.decode("#FFA500"));
        backButton.setForeground(Color.decode("#FFFFFF"));
        backButton.setFocusPainted(false); // Removes focus border
        backButton.setMaximumSize(new Dimension(60, 20));
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.remove(instructionPanel);
                frame.add(menuPanel);
                frame.revalidate();  // Revalidate layout after adding menuPanel
                frame.repaint();  // Repaint to display menuPanel
            }
        });

        topPanel.add(backButton);
        backButton.setAlignmentY(Component.TOP_ALIGNMENT);

        JTextField instructionsLabelTitle = new JTextField("=== GAME INSTRUCTIONS ===");
        instructionsLabelTitle.setFont(new Font("Monospaced", Font.BOLD, 20));
        instructionsLabelTitle.setForeground(Color.decode("#1C1C1C"));
        instructionsLabelTitle.setBorder(BorderFactory.createEmptyBorder(10, 45, 0, 0)); // Remove internal padding
        instructionsLabelTitle.setMaximumSize(new Dimension(Integer.MAX_VALUE, 25));  // Limit height
        instructionsLabelTitle.setEditable(false);

        topPanel.add(instructionsLabelTitle);
        instructionPanel.add(topPanel);

        instructionPanel.add(Box.createVerticalStrut(10));

        JTextArea instructionsTextArea = new JTextArea();
        instructionsTextArea.setText("Welcome to the adventure! Your objective is to skillfully navigate through a series of\n" +
                "platforming challenges across three exciting levels. Each level becomes progressively\n" +
                "harder and introduces new gameplay elements to keep the experience fresh and engaging.\n\n");
        instructionsTextArea.setFont(new Font("Monospaced", Font.PLAIN, 9));
        instructionsTextArea.setBackground(Color.decode("#FFA500"));
        instructionsTextArea.setForeground(Color.decode("#FFFFFF"));
        instructionsTextArea.setBorder(BorderFactory.createEmptyBorder(0, 5, -5, 0));
        instructionsTextArea.setMaximumSize(new Dimension(Integer.MAX_VALUE, 35));
        instructionsTextArea.setEditable(false);
        instructionPanel.add(instructionsTextArea);

        instructionPanel.add(Box.createVerticalStrut(10));

        JTextField objectiveLabelTitle = new JTextField("--- OBJECTIVE ---");
        objectiveLabelTitle.setFont(new Font("Monospaced", Font.BOLD, 14));
        objectiveLabelTitle.setForeground(Color.decode("#1C1C1C"));
        objectiveLabelTitle.setBorder(BorderFactory.createEmptyBorder(0, 5, 0, 0));
        objectiveLabelTitle.setMaximumSize(new Dimension(Integer.MAX_VALUE, 15));
        objectiveLabelTitle.setEditable(false);
        instructionPanel.add(objectiveLabelTitle);

        instructionPanel.add(Box.createVerticalStrut(10));

        JTextArea objectiveTextArea = new JTextArea();
        objectiveTextArea.setText("Reach the flag at the end of each level to progress to the next stage.\n" +
                "You'll need to overcome obstacles, navigate maze-like areas, and time your jumps.\n" +
                "Some jumps are simple, while others require skill and precision.\n");
        objectiveTextArea.setFont(new Font("Monospaced", Font.PLAIN, 9));
        objectiveTextArea.setBackground(Color.decode("#FFA500"));
        objectiveTextArea.setForeground(Color.decode("#FFFFFF"));
        objectiveTextArea.setBorder(BorderFactory.createEmptyBorder(0, 5, -5, 0));
        objectiveTextArea.setMaximumSize(new Dimension(Integer.MAX_VALUE, 35));
        objectiveTextArea.setEditable(false);
        instructionPanel.add(objectiveTextArea);

        instructionPanel.add(Box.createVerticalStrut(10));

        JTextField controlsLabelTitle = new JTextField("--- CONTROLS ---");
        controlsLabelTitle.setFont(new Font("Monospaced", Font.BOLD, 14));
        controlsLabelTitle.setForeground(Color.decode("#1C1C1C"));
        controlsLabelTitle.setBorder(BorderFactory.createEmptyBorder(0, 5, 0, 0));
        controlsLabelTitle.setMaximumSize(new Dimension(Integer.MAX_VALUE, 15));
        controlsLabelTitle.setEditable(false);
        instructionPanel.add(controlsLabelTitle);

        instructionPanel.add(Box.createVerticalStrut(10));

        JTextArea controlsTextArea = new JTextArea();
        controlsTextArea.setText("W - Jump / Move Up\n" +
                "A - Move Left\n" +
                "D - Move Right\n" +
                "SPACEBAR - Shoot (Levels 2 and 3 only)\n" +
                "ESC / P - Pause Game & Sound Control\n\n");
        controlsTextArea.setFont(new Font("Monospaced", Font.PLAIN, 9));
        controlsTextArea.setBackground(Color.decode("#FFA500"));
        controlsTextArea.setForeground(Color.decode("#FFFFFF"));
        controlsTextArea.setBorder(BorderFactory.createEmptyBorder(0, 5, -2, 0));
        controlsTextArea.setMaximumSize(new Dimension(Integer.MAX_VALUE, 35));
        controlsTextArea.setEditable(false);
        instructionPanel.add(controlsTextArea);

        instructionPanel.add(Box.createVerticalStrut(10));

        JTextField gameplayFeaturesLabelTitle = new JTextField("--- GAMEPLAY FEATURES ---");
        gameplayFeaturesLabelTitle.setFont(new Font("Monospaced", Font.BOLD, 14));
        gameplayFeaturesLabelTitle.setForeground(Color.decode("#1C1C1C"));
        gameplayFeaturesLabelTitle.setBorder(BorderFactory.createEmptyBorder(0, 5, 0, 0));
        gameplayFeaturesLabelTitle.setMaximumSize(new Dimension(Integer.MAX_VALUE, 15));
        gameplayFeaturesLabelTitle.setEditable(false);
        instructionPanel.add(gameplayFeaturesLabelTitle);

        instructionPanel.add(Box.createVerticalStrut(10));

        JTextArea gameplayFeaturesTextArea = new JTextArea();
        gameplayFeaturesTextArea.setText("- You begin each level with 3 lives. Losing all lives ends the game.\n" +
                "- Enemies and hazards will damage you and remove a life upon contact.\n" +
                "- Collectibles are scattered throughout each level to enhance your experience.\n" +
                "- Level 2 introduces shooting mechanics to defend against enemies.\n" +
                "- Level 3 adds new enemies and more complex challenges.\n\n");
        gameplayFeaturesTextArea.setFont(new Font("Monospaced", Font.PLAIN, 9));
        gameplayFeaturesTextArea.setBackground(Color.decode("#FFA500"));
        gameplayFeaturesTextArea.setForeground(Color.decode("#FFFFFF"));
        gameplayFeaturesTextArea.setBorder(BorderFactory.createEmptyBorder(0, 5, -1, 0));
        gameplayFeaturesTextArea.setMaximumSize(new Dimension(Integer.MAX_VALUE, 35));
        gameplayFeaturesTextArea.setEditable(false);
        instructionPanel.add(gameplayFeaturesTextArea);

        instructionPanel.add(Box.createVerticalStrut(10));

        JTextField finalWordsLabelTitle = new JTextField("--- FINAL WORDS ---");
        finalWordsLabelTitle.setFont(new Font("Monospaced", Font.BOLD, 14));
        finalWordsLabelTitle.setForeground(Color.decode("#1C1C1C"));
        finalWordsLabelTitle.setBorder(BorderFactory.createEmptyBorder(0, 5, 0, 0));
        finalWordsLabelTitle.setMaximumSize(new Dimension(Integer.MAX_VALUE, 15));
        finalWordsLabelTitle.setEditable(false);
        instructionPanel.add(finalWordsLabelTitle);

        instructionPanel.add(Box.createVerticalStrut(10));

        JTextArea finalWordsTextArea = new JTextArea();
        finalWordsTextArea.setText("Prepare for a progressively more challenging journey.\n" +
                "Each level is uniquely designed to test your reflexes, strategy, and perseverance.\n");
        finalWordsTextArea.setFont(new Font("Monospaced", Font.PLAIN, 9));
        finalWordsTextArea.setBackground(Color.decode("#FFA500"));
        finalWordsTextArea.setForeground(Color.decode("#FFFFFF"));
        finalWordsTextArea.setBorder(BorderFactory.createEmptyBorder(0, 5, 0, 0));
        finalWordsTextArea.setMaximumSize(new Dimension(Integer.MAX_VALUE, 35));
        finalWordsTextArea.setEditable(false);
        instructionPanel.add(finalWordsTextArea);

        frame.remove(menuPanel);
        frame.add(instructionPanel);
        frame.revalidate();  // Revalidate layout after adding instructionPanel
        frame.repaint();  // Repaint to display instructionPanel
    }

    /**
     * Creates and displays the pause menu panel with three buttons: "Resume", "Sound On/Off", and "Quit".
     * The "Resume" button resumes the game by starting the current level, removing the pause menu,
     * and displaying the game view again. The "Sound On/Off" button toggles the sound settings,
     * enabling or disabling background music, and updates the button text accordingly. The "Quit" button
     * exits the application when clicked.
     */
    public void getPauseMenuPanel() {
        pauseMenuPanel.removeAll();

        JLabel pauseTitle = new JLabel("Game Paused");
        pauseTitle.setFont(new Font("Monospaced", Font.BOLD, 40));
        pauseTitle.setForeground(Color.decode("#1C1C1C"));

        JButton resumeButton = new JButton("Resume");
        resumeButton.setFont(new Font("Monospaced", Font.BOLD, 15));
        resumeButton.setBackground(Color.decode("#FFA500"));
        resumeButton.setForeground(Color.decode("#FFFFFF"));
        resumeButton.setFocusPainted(false); // Removes focus border
        resumeButton.setMaximumSize(new Dimension(160, 35));
        resumeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                world.getGame().getCurrentLevel().start();
                frame.remove(pauseMenuPanel);
                frame.add(view);
                frame.revalidate();  // Revalidate layout after adding view
                frame.repaint();  // Repaint to display view
                frame.pack(); // Ensuring that everything inside the frame is visible and correctly laid out
            }
        });

        JButton soundButton = new JButton();
        if (soundEnabled) {
            soundButton.setText("Sound On");
        }
        else {
            soundButton.setText("Sound Off");
        }
        soundButton.setFont(new Font("Monospaced", Font.BOLD, 15));
        soundButton.setBackground(Color.decode("#FFA500"));
        soundButton.setForeground(Color.decode("#FFFFFF"));
        soundButton.setFocusPainted(false); // Removes focus border
        soundButton.setMaximumSize(new Dimension(160, 35));
        soundButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                soundEnabled = !soundEnabled;

                if (soundEnabled) {
                    soundButton.setText("Sound On");
                    if (currentBackgroundTrack != null) {
                        SoundManager.loop(currentBackgroundTrack);
                    }
                }
                else {
                    soundButton.setText("Sound Off");
                    if (currentBackgroundTrack != null) {
                        SoundManager.stop(currentBackgroundTrack);
                    }
                }
            }
        });

        JButton quitButton = new JButton("Quit");
        quitButton.setFont(new Font("Monospaced", Font.BOLD, 15));
        quitButton.setBackground(Color.decode("#FFA500"));
        quitButton.setForeground(Color.decode("#FFFFFF"));
        quitButton.setFocusPainted(false); // Removes focus border
        quitButton.setMaximumSize(new Dimension(160, 35));
        quitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        pauseMenuPanel.add(Box.createVerticalStrut(50));
        pauseMenuPanel.add(pauseTitle);
        pauseMenuPanel.add(Box.createVerticalStrut(50));
        pauseMenuPanel.add(resumeButton);
        pauseMenuPanel.add(Box.createVerticalStrut(40));
        pauseMenuPanel.add(soundButton);
        pauseMenuPanel.add(Box.createVerticalStrut(40));
        pauseMenuPanel.add(quitButton);

        pauseTitle.setAlignmentX(Component.CENTER_ALIGNMENT);
        resumeButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        soundButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        quitButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        frame.remove(view);
        frame.add(pauseMenuPanel);
        frame.revalidate();  // Revalidate layout after adding pauseMenuPanel
        frame.repaint();  // Repaint to display pauseMenuPanel
    }

    /**
     * Returns whether sound is enabled in the game.
     *
     * @return true if sound is enabled, false otherwise
     */
    public boolean getSoundEnabled() {
        return soundEnabled;
    }

    /**
     * Sets the current background track for the game.
     *
     * @param track the name of the background track to be set
     */
    public void setCurrentBackgroundTrack(String track) {
        currentBackgroundTrack = track;
    }

    /**
     * Returns the name of the current background track.
     *
     * @return the name of the current background track
     */
    public String getCurrentBackgroundTrack() {
        return currentBackgroundTrack;
    }
}