package game.level2;

import city.cs.engine.*;
import city.cs.engine.Shape;
import game.core.*;
import org.jbox2d.common.Vec2;
import java.awt.*;

/**
 * The Level2 class represents the second level of the game, specifically the Space theme level.
 * It extends the GameLevel class and contains the logic for the player, collisions, and level-specific behavior.
 */
public class Level2 extends GameLevel {

    /**
     * The player for this level, represented by an instance of AstronautPlayer.
     */
    private final AstronautPlayer player;

    /**
     * The game that this level belongs to.
     */
    private Game game;

    /**
     * The collision handler specific to the Space theme level.
     */
    SpacePlayerCollisions spc;

    /**
     * Creates all the bodies that are required for level 2, such as the player, static bodies, platforms,
     * enemies, collectibles.
     *
     * @param game the game that this level belongs to
     */
    public Level2(Game game) {
        super(game);
        this.game = game;

        // Make the player
        player = new AstronautPlayer(this);
        setPlayer(player);

        // Debug spawn points (uncomment if you want to test specific areas):
        player.setPosition(new Vec2(10f, -10f)); // start of the level
        //player.setPosition(new Vec2(0f, 34f)); // first moving platform
        //player.setPosition(new Vec2(0f, 50f)); // half-way room
        //player.setPosition(new Vec2(-2f, 80f)); // end of the half-way room
        //player.setPosition(new Vec2(0f, 136f)); // moving platform towards the end of the level
        //player.setPosition(new Vec2(-11.5f, 142f)); // end of the level
        //player.setPosition(new Vec2(0f, 156f)); // top level

        // Make the ground
        Ground ground1 = new Ground(this);
        ground1.setPosition(new Vec2(0f, -11.5f));
        ground1.setFillColor(new Color(11, 46, 81, 180));

        // Make the game walls
        Shape gameWallShape = new BoxShape(0.25f, 89.25f);
        StaticBody gameLeftWallBody = new StaticBody(this, gameWallShape);
        gameLeftWallBody.setPosition(new Vec2(-12.75f, 78.25f));
        StaticBody gameRightWallBody = new StaticBody(this, gameWallShape);
        gameRightWallBody.setPosition(new Vec2(12.75f, 78.25f));

        // Make the stairs section
        Platform platform1 = new Platform(this);
        platform1.setPosition(new Vec2(4f, -7f));

        BreakablePlatform platform2 = new BreakablePlatform(this);
        platform2.setPosition(new Vec2(-2f, -2.5f));

        Platform platform3 = new Platform(this);
        platform3.setPosition(new Vec2(-8f, 2f));

        BreakablePlatform platform4 = new BreakablePlatform(this);
        platform4.setPosition(new Vec2(-2f, 6.5f));

        Platform platform5 = new Platform(this);
        platform5.setPosition(new Vec2(4f, 11f));

        BreakablePlatform platform6 = new BreakablePlatform(this);
        platform6.setPosition(new Vec2(10f, 15.5f));

        Platform platform7 = new Platform(this);
        platform7.setPosition(new Vec2(4f, 20f));

        BreakablePlatform platform8 = new BreakablePlatform(this);
        platform8.setPosition(new Vec2(-2f, 24.5f));

        Platform platform9 = new Platform(this);
        platform9.setPosition(new Vec2(-8f, 29f));

        MovingPlatform mp1 = new MovingPlatform(this, new Vec2(0f, 33f), 16.75f);

        // Make the space half-way room
        SpaceHalfwayRoom spaceHalfWayRoom = new SpaceHalfwayRoom(this);

        Platform platform10 = new Platform(this);
        platform10.setPosition(new Vec2(-11f, 81.5f));

        MovingPlatform mp2 = new MovingPlatform(this, new Vec2(0f, 85f), 15f);

        Platform platform11 = new Platform(this);
        platform11.setPosition(new Vec2(11f, 98f));

        MovingPlatform mp3 = new MovingPlatform(this, new Vec2(0f, 102f), 15f);

        Platform platform12 = new Platform(this);
        platform12.setPosition(new Vec2(-11f, 120f));

        MovingPlatform mp4 = new MovingPlatform(this, new Vec2(0f, 124f), 15f);

        MovingPlatform mp5 = new MovingPlatform(this, new Vec2(-11f, 141f), 20f);
        MovingPlatform mp6 = new MovingPlatform(this, new Vec2(11f, 141f), 20f);

        Platform platform13 = new Platform(this);
        platform13.setPosition(new Vec2(-8f, 141f));

        Platform platform14 = new Platform(this);
        platform14.setPosition(new Vec2(8f, 141f));

        Ground roof = new Ground(this);
        roof.setPosition(new Vec2(0f, 167f));
        roof.setFillColor(new Color(11, 46, 81, 180));

        BreakablePlatform platform15 = new BreakablePlatform(this);
        platform15.setPosition(new Vec2(0f, 161.3f));

        // Make the space final room
        SpaceFinalRoom spaceFinalRoom = new SpaceFinalRoom(this);

        // Make the enemy aliens
        EnemyAlien enemyAlien1 = new EnemyAlien(this, new Vec2(-2f, -10f), 8f, 10f);
        player.addEnemies(enemyAlien1);
        EnemyAlien enemyAlien2 = new EnemyAlien(this, new Vec2(-6f, 51f), 2f, 10f);
        player.addEnemies(enemyAlien2);
        EnemyAlien enemyAlien3 = new EnemyAlien(this, new Vec2(0f, 163f), 6f, 10f);
        player.addEnemies(enemyAlien3);

        // Make the ammo cartridges
        bulletAmmo bulletAmmo1 = new bulletAmmo(this);
        bulletAmmo1.setPosition(new Vec2(5f, 51.25f));

        // Make the gravity boots
        GravityBoots gravityBoots = new GravityBoots(this);
        gravityBoots.setPosition(new Vec2(10.8f, 51.5f));

        // Make the hearts
        Heart heart1 = new Heart(this);
        heart1.setPosition(new Vec2(-11f, 51.25f));

        Heart heart2 = new Heart(this);
        heart2.setPosition(new Vec2(3f, 78.5f));

        // Make the stars
        Star star1 = new Star(this);
        star1.setPosition(new Vec2(4f, -5.5f));

        Star star2 = new Star(this);
        star2.setPosition(new Vec2(-8f, 3.5f));

        Star star3 = new Star(this);
        star3.setPosition(new Vec2(4f, 12.5f));

        Star star4 = new Star(this);
        star4.setPosition(new Vec2(4f, 21.5f));

        Star star5 = new Star(this);
        star5.setPosition(new Vec2(-8f, 30.5f));

        Star star6 = new Star(this);
        star6.setPosition(new Vec2(8.75f, 70f));

        Star star7 = new Star(this);
        star7.setPosition(new Vec2(-3.75f, 70f));

        Star star8 = new Star(this);
        star8.setPosition(new Vec2(2.5f, 62f));

        Star star9 = new Star(this);
        star9.setPosition(new Vec2(2.5f, 64.5f));

        Star star10 = new Star(this);
        star10.setPosition(new Vec2(2.5f, 67f));

        Star star11 = new Star(this);
        star11.setPosition(new Vec2(2.5f, 69.5f));

        Star star12 = new Star(this);
        star12.setPosition(new Vec2(2.5f, 72f));

        Star star13 = new Star(this);
        star13.setPosition(new Vec2(-11f, 83f));

        Star star14 = new Star(this);
        star14.setPosition(new Vec2(11f, 99.5f));

        Star star15 = new Star(this);
        star15.setPosition(new Vec2(-11f, 121.5f));

        Star star16 = new Star(this);
        star16.setPosition(new Vec2(-5f, 149.75f));

        Star star17 = new Star(this);
        star17.setPosition(new Vec2(5f, 149.75f));

        // Make the moons
        Moon moon1 = new Moon(this);
        moon1.setPosition(new Vec2(-9f, 46f));

        Moon moon2 = new Moon(this);
        moon2.setPosition(new Vec2(2.5f, 57f));

        Moon moon3 = new Moon(this);
        moon3.setPosition(new Vec2(-8.75f, 57f));

        Moon moon4 = new Moon(this);
        moon4.setPosition(new Vec2(8.75f, 74.5f));

        Moon moon5 = new Moon(this);
        moon5.setPosition(new Vec2(-3.75f, 74.5f));

        Moon moon6 = new Moon(this);
        moon6.setPosition(new Vec2(-11f, 97f));

        Moon moon7 = new Moon(this);
        moon7.setPosition(new Vec2(11f, 113.5f));

        // Make the meteors
        MeteorLeft meteorLeft1 = new MeteorLeft(this);
        meteorLeft1.setPosition(new Vec2(5f, 3f));

        MeteorRight meteorRight1 = new MeteorRight(this);
        meteorRight1.setPosition(new Vec2(-8f, 13f));

        MeteorLeft meteorLeft2 = new MeteorLeft(this);
        meteorLeft2.setPosition(new Vec2(4f, 31f));

        MeteorRight meteorRight2 = new MeteorRight(this);
        meteorRight2.setPosition(new Vec2(-5f, 40f));

        MeteorRight meteorRight3 = new MeteorRight(this);
        meteorRight3.setPosition(new Vec2(-6f, 93f));

        MeteorLeft meteorLeft3 = new MeteorLeft(this);
        meteorLeft3.setPosition(new Vec2(6f, 109.5f));

        // Make the american flag
        SpaceFlag spaceFlag = new SpaceFlag(this);
        spaceFlag.setPosition(new Vec2(0f, 150.4f));

        // Allow for collisions with the player
        spc = new SpacePlayerCollisions(player, this, game);
        player.addCollisionListener(spc);
    }

    /**
     * Gets the player for this level.
     *
     * @return The AstronautPlayer instance representing the player
     */
    public AstronautPlayer getPlayer() {
        return player;
    }

    /**
     * Gets the collision handler for the player in this level.
     *
     * @return The SpacePlayerCollisions instance handling player collisions
     */
    public SpacePlayerCollisions getSpacePlayerCollisions() {
        return spc;
    }
}