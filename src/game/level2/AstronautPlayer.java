package game.level2;

import city.cs.engine.*;
import game.core.GameLevel;
import game.core.SoundManager;
import game.core.BasePlayer;
import org.jbox2d.common.Vec2;
import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * The AstronautPlayer class represents the player in level 2.
 * This class manages the astronaut player, including movement, shooting bullets, and interacting with enemies.
 * It also tracks the number of stars, moons, and bullets the player has, as well as handling collisions with enemies.
 */
public class AstronautPlayer extends BasePlayer implements CollisionListener {

    /**
     * Shape of the AstronautPlayer.
     */
    private static final Shape leftPlayerShape = new BoxShape(1f, 1.8f);

    /**
     * Image of the AstronautPlayer facing left.
     */
    private static final BodyImage leftPlayerImage = new BodyImage("data/spaceTheme/astronautLeft.png", 4f);

    /**
     * Total number of stars collected by the player.
     */
    private int totalStars = 0;

    /**
     * Total number of moons collected by the player.
     */
    private int totalMoons = 0;

    /**
     * List of alien enemies that the player can interact with.
     */
    private final ArrayList<EnemyAlien> enemies;

    /**
     * The number of bullets available to the player for shooting.
     */
    private int numOfBullets;

    /**
     * Constructs an astronaut player for level 2.
     *
     * @param world the world where the player will exist and interact with other objects
     */
    public AstronautPlayer(GameLevel world) {
        super(world, leftPlayerShape, leftPlayerImage);
        this.numOfBullets = 10;
        this.enemies = new ArrayList<>();
    }

    /**
     * Sets the total number of stars collected by the player.
     *
     * @param totalStars The new total of stars collected
     */
    public void setTotalStars(int totalStars) {
        this.totalStars = totalStars;
    }

    /**
     * Returns the total number of stars collected by the player.
     *
     * @return The total number of stars collected
     */
    public int getTotalStars() {
        return totalStars;
    }

    /**
     * Sets the total number of moons collected by the player.
     *
     * @param totalMoons The new total of moons collected
     */
    public void setTotalMoons(int totalMoons) {
        this.totalMoons = totalMoons;
    }

    /**
     * Returns the total number of moons collected by the player.
     *
     * @return The total number of moons collected
     */
    public int getTotalMoons() {
        return totalMoons;
    }

    /**
     * Sets the number of bullets available to the player.
     *
     * @param numOfBullets The number of bullets to be set
     */
    public void setNumOfBullets(int numOfBullets) {
        this.numOfBullets = numOfBullets;
    }

    /**
     * Returns the number of bullets available to the player.
     *
     * @return The number of bullets available to the player
     */
    public int getNumOfBullets() {
        return numOfBullets;
    }

    /**
     * Makes the player shoot a bullet in the direction they are facing.
     * The bullet is given an initial position, image, and velocity based on the player's direction.
     */
    public void shoot() {
        Bullet bullet = new Bullet(getWorld());
        bullet.addCollisionListener(this);
        if (this.getWorld().getGame().getController().isFacingLeft()) {
            bullet.setPosition(new Vec2(this.getPosition().x - 1.2f, this.getPosition().y - 0.1f));
            bullet.addImage(bullet.getLeftImage());
            bullet.setLinearVelocity(new Vec2(-20f, 0));
        }
        else {
            bullet.setPosition(new Vec2(this.getPosition().x + 1.2f, this.getPosition().y - 0.1f));
            bullet.addImage(bullet.getRightImage());
            bullet.setLinearVelocity(new Vec2(20f, 0f));
        }
    }

    /**
     * Adds an alien enemy to the player's list of alien enemies.
     *
     * @param enemy the EnemyAlien to be added to the list
     */
    public void addEnemies(EnemyAlien enemy) {
        enemies.add(enemy);
    }

    /**
     * Handles collision events between the AstronautPlayer and other game objects, such as enemies, stars, moons etc.
     * When the player collides with an alien enemy, the enemy loses health and the player destroys the reporting body
     * after 2 seconds to not clutter the scene.
     *
     * @param e The CollisionEvent that provides information about the collision
     */
    @Override
    public void collide(CollisionEvent e) {
        if (e.getOtherBody() instanceof EnemyAlien) {
            for (int i = 0; i < enemies.size(); i++) {
                if (enemies.get(i) == e.getOtherBody()) {
                    e.getReportingBody().destroy();
                    SoundManager.play("alienDamage");
                    enemies.get(i).loseHealth();
                }
            }
        }
        Timer timer = new Timer(2000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                e.getReportingBody().destroy();
            }
        });
        timer.setRepeats(false);
        timer.start();
    }
}