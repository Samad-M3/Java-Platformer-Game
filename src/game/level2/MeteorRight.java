package game.level2;

import city.cs.engine.*;
import game.core.GameLevel;

/**
 * The MeteorRight class represents a static meteor object that is positioned and oriented to face right.
 * It extends StaticBody and is used to create meteors in the Space theme level of the game.
 */
public class MeteorRight extends StaticBody {

    /**
     * The shape of the meteor.
     */
    private static final Shape meteorShape = new PolygonShape(1.72f,-0.18f, -1.37f,2.01f, -1.79f,1.34f, 0.26f,-1.41f, 0.71f,-1.63f, 1.62f,-1.41f, 1.85f,-0.49f);

    /**
     * The image associated with the meteor, displayed when rendered in the game.
     */
    private static final BodyImage image = new BodyImage("data/spaceTheme/meteorRight.png", 5f);

    /**
     * Constructs a MeteorRight object with the specified world and shape.
     * The meteor is oriented and positioned to face right, and its image is added.
     *
     * @param world the world in which the meteor exists
     */
    public MeteorRight(GameLevel world) {
        super(world, meteorShape);
        this.addImage(image);
    }
}