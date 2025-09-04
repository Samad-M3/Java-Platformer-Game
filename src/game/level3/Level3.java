package game.level3;

import city.cs.engine.*;
import city.cs.engine.Shape;
import game.core.*;
import org.jbox2d.common.Vec2;
import java.awt.*;

/**
 * Represents Level 3 of the game, themed around magic.
 * This class sets up the environment, player, and other
 * elements specific to Level 3.
 */
public class Level3 extends GameLevel {

    /**
     * The player for this level, represented by an instance of WizardPlayer.
     */
    private final WizardPlayer player;

    /**
     * The game that this level belongs to.
     */
    private Game game;

    /**
     * The view used to display the world.
     */
    GameView view;

    /**
     * Handles collision events for the wizard player.
     */
    MagicPlayerCollisions mpc;

    /**
     * Creates all the bodies that are required for level 3, such as the player, static bodies, platforms,
     * enemies, collectibles.
     *
     * @param game the game that this level belongs to
     * @param view the GameView used to display the game world
     */
    public Level3(Game game, GameView view) {
        super(game);
        this.game = game;
        this.view = view;

        // Make the player
        player = new WizardPlayer(this);
        setPlayer(player);

        // Debug spawn points (uncomment if you want to test specific areas):
        player.setPosition(new Vec2(-10f, -10f)); // start of the game
        //player.setPosition(new Vec2(-7f, 32f)); // first set of moving platform
        //player.setPosition(new Vec2(-10.5f, 52f)); // inside the 3 enemy room
        //player.setPosition(new Vec2(-9.8f, 80f)); // after the first portal
        //player.setPosition(new Vec2(-8f, 102f)); // second set of moving platform
        //player.setPosition(new Vec2(-9.8f, 131f)); // near the breakable platforms
        //player.setPosition(new Vec2(-9.8f, 190.5f)); // final room
        //player.setPosition(new Vec2(9.8f, 190.5f)); // flag

        // Make the ground
        Ground ground1 = new Ground(this);
        ground1.setPosition(new Vec2(0f, -11.5f));
        ground1.setFillColor(new Color(47, 79, 79, 180));

        // Make the game walls
        Shape gameWallShape = new BoxShape(0.25f, 103.375f);
        StaticBody gameLeftWallBody = new StaticBody(this, gameWallShape);
        gameLeftWallBody.setPosition(new Vec2(-12.75f, 92.375f));
        StaticBody gameRightWallBody = new StaticBody(this, gameWallShape);
        gameRightWallBody.setPosition(new Vec2(12.75f, 92.375f));

        // Make the initial platforms
        Platform platform1 = new Platform(this);
        platform1.setPosition(new Vec2(2f, -6.5f));

        Platform platform2 = new Platform(this);
        platform2.setPosition(new Vec2(-9f, -1.5f));

        Platform platform3 = new Platform(this);
        platform3.setPosition(new Vec2(7f, 3f));

        Platform platform4 = new Platform(this);
        platform4.setPosition(new Vec2(-9.5f, 7.8f));

        Platform platform5 = new Platform(this);
        platform5.setPosition(new Vec2(9f, 12f));

        Platform platform6 = new Platform(this);
        platform6.setPosition(new Vec2(-8f, 16.6f));

        Platform platform7 = new Platform(this);
        platform7.setPosition(new Vec2(10f, 21.1f));

        Platform platform8 = new Platform(this);
        platform8.setPosition(new Vec2(-4f, 26f));

        // Make the moving platform
        MovingPlatform movingPlatform1 = new MovingPlatform(this, new Vec2(-7f, 30f), 21f);

        // Make the MagicHalfwayRoom
        Shape firstFloorLeftShape = new BoxShape(2f, 0.3f);
        StaticBody firstFloorLeftBody = new StaticBody(this, firstFloorLeftShape);
        firstFloorLeftBody.setPosition(new Vec2(-10.5f, 51f));
        firstFloorLeftBody.setFillColor(new Color(47, 79, 79, 180));

        Shape firstFloorRightShape = new BoxShape(9f, 0.3f);
        StaticBody firstFloorRightBody = new StaticBody(this, firstFloorRightShape);
        firstFloorRightBody.setPosition(new Vec2(3.5f, 51f));
        firstFloorRightBody.setFillColor(new Color(47, 79, 79, 180));

        Shape secondFloorShape = new BoxShape(10.5f, 0.3f);
        StaticBody secondFloorBody = new StaticBody(this, secondFloorShape);
        secondFloorBody.setPosition(new Vec2(-2f, 55.9f));
        secondFloorBody.setFillColor(new Color(47, 79, 79, 180));

        StaticBody thirdFloorBody = new StaticBody(this, secondFloorShape);
        thirdFloorBody.setPosition(new Vec2(2f, 60.8f));
        thirdFloorBody.setFillColor(new Color(47, 79, 79, 180));

        Shape roofShape = new BoxShape(12.5f, 0.3f);
        StaticBody roofBody1 = new StaticBody(this, roofShape);
        roofBody1.setPosition(new Vec2(0f, 65.7f));
        roofBody1.setFillColor(new Color(47, 79, 79, 180));

        Platform safteyPlatform = new Platform(this);
        safteyPlatform.setPosition(new Vec2(2f, 70f));

        Platform platform9 = new Platform(this);
        platform9.setPosition(new Vec2(-9f, 73f));

        Platform platform10 = new Platform(this);
        platform10.setPosition(new Vec2(6f, 78f));

        Platform platform11 = new Platform(this);
        platform11.setPosition(new Vec2(-8.2f, 83f));

        Platform platform12 = new Platform(this);
        platform12.setPosition(new Vec2(10f, 87.4f));

        Platform platform13 = new Platform(this);
        platform13.setPosition(new Vec2(-8f, 91.6f));

        Platform platform14 = new Platform(this);
        platform14.setPosition(new Vec2(9f, 96.2f));

        MovingPlatform movingPlatform2 = new MovingPlatform(this, new Vec2(-8f, 98f), 23f);

        StaticBody roofBody2 = new  StaticBody(this, roofShape);
        roofBody2.setPosition(new Vec2(0f, 130f));
        roofBody2.setFillColor(new Color(47, 79, 79, 180));

        // Make the breakable platforms
        BreakablePlatform breakablePlatform1 = new BreakablePlatform(this);
        breakablePlatform1.setPosition(new Vec2(2f, 134.8f));

        BreakablePlatform breakablePlatform2 = new BreakablePlatform(this);
        breakablePlatform2.setPosition(new Vec2(-11f, 139.6f));

        BreakablePlatform breakablePlatform3 = new BreakablePlatform(this);
        breakablePlatform3.setPosition(new Vec2(-3f, 144.4f));

        BreakablePlatform breakablePlatform4 = new BreakablePlatform(this);
        breakablePlatform4.setPosition(new Vec2(8f, 149.2f));

        BreakablePlatform breakablePlatform5 = new BreakablePlatform(this);
        breakablePlatform5.setPosition(new Vec2(-6f, 154f));

        BreakablePlatform breakablePlatform6 = new BreakablePlatform(this);
        breakablePlatform6.setPosition(new Vec2(10f, 158.6f));

        BreakablePlatform breakablePlatform7 = new BreakablePlatform(this);
        breakablePlatform7.setPosition(new Vec2(-6f, 163.2f));

        BreakablePlatform breakablePlatform8 = new BreakablePlatform(this);
        breakablePlatform8.setPosition(new Vec2(3.5f, 168f));

        // Make the final room
        StaticBody floorBody3 = new StaticBody(this, roofShape);
        floorBody3.setPosition(new Vec2(0f, 190f));
        floorBody3.setFillColor(new Color(47, 79, 79, 180));

        StaticBody roofBody4 = new StaticBody(this, roofShape);
        roofBody4.setPosition(new Vec2(0f, 196f));
        roofBody4.setFillColor(new Color(47, 79, 79, 180));

        // Allow for collisions with the player
        mpc = new MagicPlayerCollisions(player, this, game);
        player.addCollisionListener(mpc);

        // Make the portals
        RightPortal rightPortal1 = new RightPortal(this);
        rightPortal1.setPosition(new Vec2(11.7f, 63f));
        mpc.addRightPortal(rightPortal1);

        LeftPortal leftPortal1 = new LeftPortal(this);
        leftPortal1.setPosition(new Vec2(-11.7f, 79f));
        mpc.addLeftPortal(leftPortal1);

        RightPortal rightPortal2 = new RightPortal(this);
        rightPortal2.setPosition(new Vec2(11.7f, 122f));
        mpc.addRightPortal(rightPortal2);

        LeftPortal leftPortal2 = new LeftPortal(this);
        leftPortal2.setPosition(new Vec2(-11.7f, 132.2f));
        mpc.addLeftPortal(leftPortal2);

        RightPortal rightPortal3 = new RightPortal(this);
        rightPortal3.setPosition(new Vec2(11.7f, 174f));
        mpc.addRightPortal(rightPortal3);

        LeftPortal leftPortal3 = new LeftPortal(this);
        leftPortal3.setPosition(new Vec2(-11.7f, 192.7f));
        mpc.addLeftPortal(leftPortal3);

        // Make the enemy wizards
        EnemyWizard enemyWizard1 = new EnemyWizard(this, new Vec2(2f, 52.25f), 5f, 10f);
        player.addEnemies(enemyWizard1);
        EnemyWizard enemyWizard2 = new EnemyWizard(this, new Vec2(-0.5f, 57.15f), 6.5f, 10f);
        player.addEnemies(enemyWizard2);
        EnemyWizard enemyWizard3 = new EnemyWizard(this, new Vec2(-0.2f, 62.05f), 5.5f, 10f);
        player.addEnemies(enemyWizard3);
        EnemyWizard enemyWizard4 = new EnemyWizard(this, new Vec2(-1f, 191.25f), 5f, 10f);
        player.addEnemies(enemyWizard4);
        EnemyWizard enemyWizard5 = new EnemyWizard(this, new Vec2(2f, -10f), 7f, 10f);
        player.addEnemies(enemyWizard5);

        // Make the potions
        MagicPotion magicPotion1 = new MagicPotion(this);
        magicPotion1.setPosition(new Vec2(7f, 4.5f));

        MagicPotion magicPotion2 = new MagicPotion(this);
        magicPotion2.setPosition(new Vec2(-8f, 18.1f));

        MagicPotion magicPotion3 = new MagicPotion(this);
        magicPotion3.setPosition(new Vec2(10f, 88.9f));

        MagicPotion magicPotion4 = new MagicPotion(this);
        magicPotion4.setPosition(new Vec2(10f, 122f));

        MagicPotion magicPotion5 = new MagicPotion(this);
        magicPotion5.setPosition(new Vec2(7.5f, 192.3f));

        // Make the pink magical books
        PinkMagicBook pinkMagicBook1 = new PinkMagicBook(this);
        pinkMagicBook1.setPosition(new Vec2(2f, -5f));

        PinkMagicBook pinkMagicBook2 = new PinkMagicBook(this);
        pinkMagicBook2.setPosition(new Vec2(-9.5f, 9.3f));

        PinkMagicBook pinkMagicBook3 = new PinkMagicBook(this);
        pinkMagicBook3.setPosition(new Vec2(10f, 22.6f));

        PinkMagicBook pinkMagicBook4 = new PinkMagicBook(this);
        pinkMagicBook4.setPosition(new Vec2(10.5f, 53f));

        PinkMagicBook pinkMagicBook5 = new PinkMagicBook(this);
        pinkMagicBook5.setPosition(new Vec2(9f, 62.8f));

        PinkMagicBook pinkMagicBook6 = new PinkMagicBook(this);
        pinkMagicBook6.setPosition(new Vec2(6f, 79.5f));

        PinkMagicBook pinkMagicBook7 = new PinkMagicBook(this);
        pinkMagicBook7.setPosition(new Vec2(-8f, 93.1f));

        PinkMagicBook pinkMagicBook8 = new PinkMagicBook(this);
        pinkMagicBook8.setPosition(new Vec2(2f, 136.3f));

        PinkMagicBook pinkMagicBook9 = new PinkMagicBook(this);
        pinkMagicBook9.setPosition(new Vec2(-6f, 155.5f));

        PinkMagicBook pinkMagicBook10 = new PinkMagicBook(this);
        pinkMagicBook10.setPosition(new Vec2(3.5f, 169.5f));

        // Make the blue magical books
        BlueMagicBook blueMagicBook1 = new BlueMagicBook(this);
        blueMagicBook1.setPosition(new Vec2(-9f, 0f));

        BlueMagicBook blueMagicBook2 = new BlueMagicBook(this);
        blueMagicBook2.setPosition(new Vec2(9f, 13.5f));

        BlueMagicBook blueMagicBook3 = new BlueMagicBook(this);
        blueMagicBook3.setPosition(new Vec2(-4f, 27.5f));

        BlueMagicBook blueMagicBook4 = new BlueMagicBook(this);
        blueMagicBook4.setPosition(new Vec2(-10.5f, 57.9f));

        BlueMagicBook blueMagicBook5 = new BlueMagicBook(this);
        blueMagicBook5.setPosition(new Vec2(-8.2f, 84.5f));

        BlueMagicBook blueMagicBook6 = new BlueMagicBook(this);
        blueMagicBook6.setPosition(new Vec2(9f, 97.7f));

        BlueMagicBook blueMagicBook7 = new BlueMagicBook(this);
        blueMagicBook7.setPosition(new Vec2(-11f, 141.1f));

        BlueMagicBook blueMagicBook8 = new BlueMagicBook(this);
        blueMagicBook8.setPosition(new Vec2(8f, 150.7f));

        BlueMagicBook blueMagicBook9 = new BlueMagicBook(this);
        blueMagicBook9.setPosition(new Vec2(-6f, 164.7f));

        // Make the fireball ammo
        FireballAmmo fireballAmmo = new FireballAmmo(this);
        fireballAmmo.setPosition(new Vec2(-11.5f, 53f));

        // Make the hearts
        Heart heart1 = new Heart(this);
        heart1.setPosition(new Vec2(-9.5f, 53f));

        // Make the flag
        MagicFlag magicFlag = new MagicFlag(this);
        magicFlag.setPosition(new Vec2(10f, 192.3f));
    }

    /**
     * Gets the player character for Level 3.
     *
     * @return the WizardBasePlayer instance
     */
    public WizardPlayer getPlayer() {
        return player;
    }

    /**
     * Gets the current game view.
     *
     * @return the GameView object used to render the level
     */
    public GameView getView() {
        return view;
    }
}