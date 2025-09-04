package game.level1;

import city.cs.engine.*;
import city.cs.engine.Shape;
import game.core.*;
import org.jbox2d.common.Vec2;
import java.awt.*;

/**
 * This class represents Level 1 of the game, featuring a pirate theme. It sets up all the bodies of the level,
 * including the player, platforms, enemies, collectibles.
 */
public class Level1 extends GameLevel {

    /**
     * The player for this level, represented by an instance of PiratePlayer
     */
    private final PiratePlayer player;

    /**
     * The game that this level belongs to.
     */
    private Game game;

    /**
     * Creates all the bodies that are required for level 1, such as the player, static bodies, platforms,
     * enemies, collectibles.
     *
     * @param game the game that this level belongs to
     */
    public Level1(Game game) {
        super(game);
        this.game = game;

        // Make the ground
        Ground ground = new Ground(this);
        ground.setPosition(new Vec2(0f, -11.5f));

        // Make the game walls
        Wall leftWall = new Wall(this);
        leftWall.setPosition(new Vec2(-12.75f, 62));

        Wall rightWall = new Wall(this);
        rightWall.setPosition(new Vec2(12.75f, 62));

        // Make the player
        player = new PiratePlayer(this);
        setPlayer(player);

        // Debug spawn points (uncomment if you want to test specific areas):
        player.setPosition(new Vec2(-8f, -10f)); // start of the level
        //player.setPosition(new Vec2(8f, 41f)); // hideaway room
        //player.setPosition(new Vec2(0f, 49f)); // trampoline
        //player.setPosition(new Vec2(0f, 69f)); // breakable platforms
        //player.setPosition(new Vec2(12f, 128.5f)); // final room
        //player.setPosition(new Vec2(-9f, 128.5f)); // near the flag

        // Make the suspended platforms
        Platform suspendedPlatform1 = new Platform(this);
        suspendedPlatform1.setPosition(new Vec2(7f, -8f));

        Platform suspendedPlatform2 = new Platform(this);
        suspendedPlatform2.setPosition(new Vec2(-9f, -4f));

        Platform suspendedPlatform3 = new Platform(this);
        suspendedPlatform3.setPosition(new Vec2(2f, 0.5f));

        Platform suspendedPlatform4 = new Platform(this);
        suspendedPlatform4.setPosition(new Vec2(-8f, 5f));

        Platform suspendedPlatform5 = new Platform(this);
        suspendedPlatform5.setPosition(new Vec2(8f, 9.5f));

        Platform suspendedPlatform6 = new Platform(this);
        suspendedPlatform6.setPosition(new Vec2(-7f, 14f));

        Platform suspendedPlatform9 = new Platform(this);
        suspendedPlatform9.setPosition(new Vec2(0f, 104f));

        for (int i = 0; i < 4; i++) {
            float yLevel = 52;
            Platform suspendedPlatform7 = new Platform(this);
            suspendedPlatform7.setPosition(new Vec2( 0f, yLevel + (i*5) ));
        }

        // Shielding platform to stop the player going too high from the trampoline
        Platform suspendedPlatform8 = new Platform(this);
        suspendedPlatform8.setPosition(new Vec2(10f, 68f));

        // Shielding wall
        Shape shieldingShape = new BoxShape(0.3f, 7f);
        StaticBody shieldingWall = new StaticBody(this, shieldingShape);
        shieldingWall.setPosition(new Vec2(7f, 61f));
        shieldingWall.setFillColor(new Color(160, 220, 204, 180));

        // Make the trampoline
        Trampoline trampoline1 = new Trampoline(this, new Vec2(10f, 49.2f));

        // Make the moving platforms
        MovingPlatform movingPlatform1 = new MovingPlatform(this, new Vec2(2f, 18f), 10);

        MovingPlatform movingPlatform2 = new MovingPlatform(this, new Vec2(11f, 25f), 15);

        MovingPlatform movingPlatform3 = new MovingPlatform(this, new Vec2(-11f, 40f), 8.25f);

        MovingPlatform movingPlatform4 = new MovingPlatform(this, new Vec2(9.5f, 108f), 20);

        // Make the pirate halfway room
        PirateHalfwayRoom pirateHalfwayRoom = new PirateHalfwayRoom(this);

        // Make the breakable platforms
        BreakablePlatform breakablePlatform1 = new BreakablePlatform(this);
        breakablePlatform1.setPosition(new Vec2(9.5f, 71.8f));

        BreakablePlatform breakablePlatform2 = new BreakablePlatform(this);
        breakablePlatform2.setPosition(new Vec2(-4f, 76.5f));

        BreakablePlatform breakablePlatform3 = new BreakablePlatform(this);
        breakablePlatform3.setPosition(new Vec2(-8.5f, 81.2f));

        BreakablePlatform breakablePlatform4 = new BreakablePlatform(this);
        breakablePlatform4.setPosition(new Vec2(3f, 86f));

        BreakablePlatform breakablePlatform5 = new BreakablePlatform(this);
        breakablePlatform5.setPosition(new Vec2(-9f, 90.8f));

        BreakablePlatform breakablePlatform6 = new BreakablePlatform(this);
        breakablePlatform6.setPosition(new Vec2(7.5f, 95f));

        BreakablePlatform breakablePlatform7 = new BreakablePlatform(this);
        breakablePlatform7.setPosition(new Vec2(-9f, 99.5f));

        // Make the end room
        PirateFinalRoom pirateFinalRoom = new PirateFinalRoom(this);

        // Make the flag
        PirateFlag pirateFlag = new PirateFlag(this);
        pirateFlag.setPosition(new Vec2(-10f, 129.8f));

        // Make the coins
        Coin coin1 = new Coin(this);
        coin1.setPosition(new Vec2(7f, -6.5f));

        Coin coin2 = new Coin(this);
        coin2.setPosition(new Vec2(2f, 2f));

        Coin coin3 = new Coin(this);
        coin3.setPosition(new Vec2(8f, 11f));

        Coin coin4 = new Coin(this);
        coin4.setPosition(new Vec2(2f, 19.5f));

        Coin coin5 = new Coin(this);
        coin5.setPosition(new Vec2(11f, 41.5f));

        Coin coin6 = new Coin(this);
        coin6.setPosition(new Vec2(0f, 45.8f));

        Coin coin7 = new Coin(this);
        coin7.setPosition(new Vec2(-11f, 36f));

        Coin coin8 = new Coin(this);
        coin8.setPosition(new Vec2(10f, 66.5f));

        Coin coin9 = new Coin(this);
        coin9.setPosition(new Vec2(10f, 63.5f));

        Coin coin10 = new Coin(this);
        coin10.setPosition(new Vec2(10f, 60.5f));

        Coin coin11 = new Coin(this);
        coin11.setPosition(new Vec2(10f, 57.5f));

        Coin coin12 = new Coin(this);
        coin12.setPosition(new Vec2(10f, 54.5f));

        Coin coin13 = new Coin(this);
        coin13.setPosition(new Vec2(0f, 58.5f));

        Coin coin14 = new Coin(this);
        coin14.setPosition(new Vec2(0f, 68.5f));

        Coin coin15 = new Coin(this);
        coin15.setPosition(new Vec2(-4f, 78f));

        Coin coin16 = new Coin(this);
        coin16.setPosition(new Vec2(3f, 87.5f));

        Coin coin17 = new Coin(this);
        coin17.setPosition(new Vec2(7.5f, 96.5f));

        Coin coin18 = new Coin(this);
        coin18.setPosition(new Vec2(7f, 129.5f));

        // Make the treasure chests
        TreasureChest treasureChest1 = new TreasureChest(this);
        treasureChest1.setPosition(new Vec2(-6.75f, 45.8f));

        TreasureChest treasureChest2 = new TreasureChest(this);
        treasureChest2.setPosition(new Vec2(-9f, 122f));

        // Make the hearts
        Heart heart1 = new Heart(this);
        heart1.setPosition(new Vec2(8.25f, 45.8f));

        Heart heart2 = new Heart(this);
        heart2.setPosition(new Vec2(-9f, 110));

        // Make the enemies
        EnemyPirate enemyPirate1 = new EnemyPirate(this, new Vec2(0f, -10f), 4f, 10f);

        EnemyPirate enemyPirate2 = new EnemyPirate(this, new Vec2(0, 41), 5f, 13f);

        EnemyPirate enemyPirate3 = new EnemyPirate(this, new Vec2(0f, 128.3f), 5.5f, 12f);

        // Make the spikes
        Spike spike1 = new Spike(this);
        spike1.setPosition(new Vec2(0f, 56.2f));

        Spike spike2 = new Spike(this);
        spike2.setPosition(new Vec2(0f, 61.2f));

        Spike spike3 = new Spike(this);
        spike3.setPosition(new Vec2(0f, 66.2f));

        Spike spike4 = new Spike(this);
        spike4.setPosition(new Vec2(10f, 67.2f));

        // Allow for collisions with the player
        PiratePlayerCollisions ppc = new PiratePlayerCollisions(player, this, game);
        player.addCollisionListener(ppc);
    }

    /**
     * Returns the player reference for this level.
     *
     * @return the player reference for this level
     */
    public PiratePlayer getPlayer() {
        return player;
    }
}