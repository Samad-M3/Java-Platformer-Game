package game.level2;

import city.cs.engine.*;
import game.core.GameLevel;

/**
 * The MeteorLeft class represents a static meteor object that is positioned and oriented to face left.
 * It extends StaticBody and is used to create meteors in the Space theme level of the game.
 */
public class MeteorLeft extends StaticBody {

    /**
     * The shape of the meteor.
     */
    private static final Shape meteorShape = new PolygonShape(-1.66f,-0.04f, 1.41f,2.01f, 1.78f,1.36f, -0.26f,-1.45f, -1.13f,-1.63f, -1.71f,-1.27f, -1.88f,-0.5f);

    /**
     * The image associated with the meteor, displayed when rendered in the game.
     */
    private static final BodyImage image = new BodyImage("data/spaceTheme/meteorLeft.png", 5f);

    /**
     * Constructs a MeteorLeft object with the specified world and shape.
     * The meteor is oriented and positioned to face left, and its image is added.
     *
     * @param world the world in which the meteor exists
     */
    public MeteorLeft(GameLevel world) {
        super(world, meteorShape);
        this.addImage(image);
    }
}