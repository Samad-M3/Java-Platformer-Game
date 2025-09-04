package game.core;

import city.cs.engine.UserView;
import game.level1.PiratePlayer;
import game.level3.WizardPlayer;
import game.level2.AstronautPlayer;
import javax.swing.*;
import java.awt.*;

/**
 * Represents the view for the game, responsible for rendering the background, foreground
 * and other visual elements for each level.
 */
public class GameView extends UserView {

    /**
     * The player instance associated with this game view.
     */
    private BasePlayer basePlayer;

    /**
     * The current game level in which the player is playing.
     */
    private GameLevel world;

    /**
     * Indicates whether the game is over.
     * Set to true when the player reaches the flag in the final level, signaling that the game is complete,
     * and the overall statistics should be rendered in the foreground.
     */
    private boolean gameOver;

    /**
     * The background image for the pirate-themed level.
     */
    private Image pirateBackground;

    /**
     * The background image for the space-themed level.
     */
    private Image spaceBackground;

    /**
     * The background image for the magic-themed level.
     */
    private Image magicBackground;

    /**
     * The image of a heart collectible.
     */
    private Image heart;

    /**
     * The image of a coin collectible.
     */
    private Image coin;

    /**
     * The image of a star collectible.
     */
    private Image star;

    /**
     * The image of a moon collectible.
     */
    private Image moon;

    /**
     * The image of a space bullet projectile.
     */
    private Image spaceBullet;

    /**
     * The image of a pink magic book collectible.
     */
    private Image pinkMagicBook;

    /**
     * The image of a blue magic book collectible.
     */
    private Image blueMagicBook;

    /**
     * The image of a magic bullet projectile.
     */
    private Image magicBullet;

    /**
     * The total number of coins collected by the player.
     */
    private int coins = 0;

    /**
     * The total number of stars collected by the player.
     */
    private int stars = 0;

    /**
     * The total number of moons collected by the player.
     */
    private int moons = 0;

    /**
     * The total number of bullets not used by the player.
     */
    private int bullets = 0;

    /**
     * The total number of pink magic books collected by the player.
     */
    private int pinkBooks = 0;

    /**
     * The total number of blue magic books collected by the player.
     */
    private int blueBooks = 0;

    /**
     * The total number of fireballs not used by the player.
     */
    private int fireballs = 0;

    /**
     * Constructs a GameView for the given world, dimensions, and player reference.
     *
     * @param world the GameLevel instance that the view will display
     * @param width the width of the view
     * @param height the height of the view
     * @param basePlayer the player instance associated with this view
     */
    public GameView(GameLevel world, int width, int height, BasePlayer basePlayer) {
        super(world, width, height);

        // Load all the images from the "data" folder
        try {
            pirateBackground = new ImageIcon("data/pirateTheme/background.png").getImage();
        } catch (Exception e) {
            System.out.println("Error loading pirate background: " + e.getMessage());
        }
        try {
            spaceBackground = new ImageIcon("data/spaceTheme/spaceBackground.png").getImage();
        } catch (Exception e) {
            System.out.println("Error loading space background: " + e.getMessage());
        }
        try {
            magicBackground = new ImageIcon("data/magicTheme/magicBackground.png").getImage();
        } catch (Exception e) {
            System.out.println("Error loading magic background: " + e.getMessage());
        }
        try {
            heart = new ImageIcon("data/pirateTheme/heart.png").getImage();
        } catch (Exception e) {
            System.out.println("Error loading heart: " + e.getMessage());
        }
        try {
            coin = new ImageIcon("data/pirateTheme/coin.png").getImage();
        } catch (Exception e) {
            System.out.println("Error loading coin: " + e.getMessage());
        }
        try {
            star = new ImageIcon("data/spaceTheme/star.png").getImage();
        } catch (Exception e) {
            System.out.println("Error loading star: " + e.getMessage());
        }
        try {
            moon = new ImageIcon("data/spaceTheme/moon.png").getImage();
        } catch (Exception e) {
            System.out.println("Error loading moon: " + e.getMessage());
        }
        try {
            spaceBullet = new ImageIcon("data/spaceTheme/bulletRight.png").getImage();
        } catch (Exception e) {
            System.out.println("Error loading space bullet: " + e.getMessage());
        }
        try {
            pinkMagicBook = new ImageIcon("data/magicTheme/magicBook1.png").getImage();
        } catch (Exception e) {
            System.out.println("Error loading pink magic book: " + e.getMessage());
        }
        try {
            blueMagicBook = new ImageIcon("data/magicTheme/magicBook2.png").getImage();
        } catch (Exception e) {
            System.out.println("Error loading blue magic book: " + e.getMessage());
        }
        try {
            magicBullet = new ImageIcon("data/magicTheme/fireballRight.png").getImage();
        } catch (Exception e) {
            System.out.println("Error loading magic bullet: " + e.getMessage());
        }
        this.basePlayer = basePlayer;
        this.world = world;
    }

    /**
     * Paints the background of the game window based on the type of player character.
     * The background image is drawn to fill the entire game window.
     *
     * @param g the Graphics2D object used to render the background image
     */
    @Override
    protected void paintBackground(Graphics2D g) {
        // Draw the background image to fill the entire game window
        if (basePlayer instanceof PiratePlayer) {
            g.drawImage(pirateBackground, 0, 0, getWidth(), getHeight(), this);
        }
        else if (basePlayer instanceof AstronautPlayer) {
            g.drawImage(spaceBackground, 0, 0, getWidth(), getHeight(), this);
        }
        else if (basePlayer instanceof WizardPlayer) {
            g.drawImage(magicBackground, 0, 0, getWidth(), getHeight(), this);
        }
    }

    /**
     * Paints the foreground HUD (Head-Up Display) to show player stats.
     * The displayed stats vary based on the type of player character.
     *
     * @param g the Graphics2D object used to render the HUD elements
     */
    @Override
    protected void paintForeground(Graphics2D g) {
        // On-screen HUD to show player stats
        if (basePlayer instanceof PiratePlayer) {
            // Number of coins collected stat
            int inGameCoins = ((PiratePlayer) basePlayer).getCoins();
            coins = inGameCoins;
            g.drawImage(coin, -5, -5, 50, 50, this);
            g.setColor(Color.white);
            g.setFont(new Font("Times New Roman", Font.PLAIN, 25));
            g.drawString("X" + String.valueOf(inGameCoins), 38, 27);

            // Number of lives remaining stat
            for (int i = 0; i < basePlayer.getLives(); i++) {
                g.drawImage(heart, 470, 5 + (i * 30), 25, 25, this);
            }

            if (basePlayer.getLives() == 0) {
                g.setColor(new Color(251, 250, 250, 180));
                g.fillRect(0, 0, getWidth(), getHeight());
                g.setColor(Color.black);
                g.setFont(new Font("Monospaced", Font.BOLD, 45));
                g.drawString("Game Over,", 70, 150);
                g.drawString("You Lose", 70, 190);
            }
        }
        else if (basePlayer instanceof AstronautPlayer) {
            // Number of stars collected stat
            int inGameStars = ((AstronautPlayer) basePlayer).getTotalStars();
            stars = inGameStars;
            g.drawImage(star, -5, 2, 50, 50, this);
            g.setColor(Color.white);
            g.setFont(new Font("Times New Roman", Font.PLAIN, 25));
            g.drawString("X" + String.valueOf(inGameStars), 38, 37);

            // Number of moons collected stat
            int inGameMoons = ((AstronautPlayer) basePlayer).getTotalMoons();
            moons = inGameMoons;
            g.drawImage(moon, -5, 47, 50, 50, this);
            g.setColor(Color.white);
            g.setFont(new Font("Times New Roman", Font.PLAIN, 25));
            g.drawString("X" + String.valueOf(inGameMoons), 38, 77);

            // Number of bullets remaining stat
            int inGameBullets = ((AstronautPlayer) basePlayer).getNumOfBullets();
            bullets = inGameBullets;
            g.drawImage(spaceBullet, -20, 77, 80, 80, this);
            g.setColor(Color.white);
            g.setFont(new Font("Times New Roman", Font.PLAIN, 25));
            g.drawString("X" + String.valueOf(inGameBullets), 38, 117);

            // Number of lives remaining stat
            for (int i = 0; i < basePlayer.getLives(); i++) {
                g.drawImage(heart, 470, 5 + (i * 30), 25, 25, this);
            }

            if (basePlayer.getLives() == 0) {
                g.setColor(new Color(251, 250, 250, 180));
                g.fillRect(0, 0, getWidth(), getHeight());
                g.setColor(Color.black);
                g.setFont(new Font("Monospaced", Font.BOLD, 45));
                g.drawString("Game Over,", 70, 150);
                g.drawString("You Lose", 70, 190);
            }
        }
        else if (basePlayer instanceof WizardPlayer) {
            // Number of pink books collected stat
            int inGamePinkBooks = ((WizardPlayer) basePlayer).getTotalPinkBooks();
            pinkBooks = inGamePinkBooks;
            g.drawImage(pinkMagicBook, 2, 2, 50, 50, this);
            g.setColor(Color.white);
            g.setFont(new Font("Times New Roman", Font.PLAIN, 25));
            g.drawString("X" + String.valueOf(inGamePinkBooks), 50, 36);

            // Number of blue books collected stat
            int inGameBlueBooks = ((WizardPlayer) basePlayer).getTotalBlueBooks();
            blueBooks = inGameBlueBooks;
            g.drawImage(blueMagicBook, 2, 40, 50, 50, this);
            g.setColor(Color.white);
            g.setFont(new Font("Times New Roman", Font.PLAIN, 25));
            g.drawString("X" + String.valueOf(inGameBlueBooks), 50, 72);

            // Number of fireballs remaining stat
            int inGameFireballs = ((WizardPlayer) basePlayer).getNumOfFireballs();
            fireballs = inGameFireballs;
            g.drawImage(magicBullet, 2, 76, 50, 50, this);
            g.setColor(Color.white);
            g.setFont(new Font("Times New Roman", Font.PLAIN, 25));
            g.drawString("X" + String.valueOf(inGameFireballs), 50, 108);

            // Number of lives remaining stat
            for (int i = 0; i < basePlayer.getLives(); i++) {
                g.drawImage(heart, 470, 5 + (i * 30), 25, 25, this);
            }

            if (basePlayer.getLives() == 0) {
                g.setColor(new Color(251, 250, 250, 180));
                g.fillRect(0, 0, getWidth(), getHeight());
                g.setColor(Color.black);
                g.setFont(new Font("Monospaced", Font.BOLD, 45));
                g.drawString("Game Over,", 70, 150);
                g.drawString("You Lose", 70, 190);
            }
        }

        // When gameOver becomes true, the overall statistics should be rendered in the foreground
        if (gameOver) {
            // Create a transparent white foreground and fill the entire window
            g.setColor(new Color(251, 250, 250, 180));
            g.fillRect(0, 0, getWidth(), getHeight());

            // General text
            g.setColor(Color.black);
            g.setFont(new Font("Monospaced", Font.BOLD, 45));
            g.drawString("Game Over,", 70, 75);
            g.drawString("You Win", 70, 115);

            // Statistics text
            g.setFont(new Font("Monospaced", Font.PLAIN, 30));

            g.drawImage(coin, 60, 151, 50,50, this);
            g.drawString("Coins Collected: ", 110, 185);
            g.drawString(String.valueOf(coins), 400, 187);

            g.drawImage(star, 65, 196, 40,40, this);
            g.drawString("Stars Collected: ", 110, 227);
            g.drawString(String.valueOf(stars), 400, 229);

            g.drawImage(moon, 60, 236, 50,50, this);
            g.drawString("Moons Collected: ", 110, 269);
            g.drawString(String.valueOf(moons), 400, 271);

            g.drawImage(spaceBullet, 45, 270, 80, 80, this);
            g.drawString("Bullets Left: ", 110, 311);
            g.drawString(String.valueOf(bullets), 348, 313);

            g.drawImage(pinkMagicBook, 59, 319, 50, 50, this);
            g.drawString("Books Collected: ", 110, 353);
            g.drawString(String.valueOf(pinkBooks), 400, 355);

            g.drawImage(blueMagicBook, 59, 362, 50, 50, this);
            g.drawString("Tomes Collected: ", 110, 395);
            g.drawString(String.valueOf(blueBooks), 400, 397);

            g.drawImage(magicBullet, 57, 405, 50, 50, this);
            g.drawString("Fireballs Left: ", 110, 437);
            g.drawString(String.valueOf(fireballs), 383, 439);
        }
    }

    /**
     * Set the player so that the view knows what background to set and what on-screen HUD to display.
     *
     * @param basePlayer the player instance that will be set in the view
     */
    public void setPlayer(BasePlayer basePlayer) {
        this.basePlayer = basePlayer;
    }

    /**
     * Sets the game-over status, indicating whether the player has reached the flag in the final level.
     * This method can be called from other classes with access to the GameView to update the game's state.
     *
     * @param gameOver a boolean value representing the game-over status; true if the game is over
     */
    public void setGameOver(boolean gameOver) {
        this.gameOver = gameOver;
    }
}