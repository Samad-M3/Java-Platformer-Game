package game.core;

import city.cs.engine.SoundClip;
import java.util.HashMap;
import java.io.IOException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.sound.sampled.LineUnavailableException;

/**
 * The SoundManager class handles loading, playing, looping, and stopping
 * sound effects and background music across different levels in the game.
 */
public class SoundManager {

    /**
     * A map that stores sound clips associated with their string keys.
     */
    private static HashMap<String, SoundClip> sounds = new HashMap<>();

    /**
     * Static initializer block that loads all sounds used in the game.
     * This includes general sounds as well as level-specific sounds.
     */
    static {
        try {
            // General sounds that apply to all levels
            sounds.put("defeat", new SoundClip("data/generalSounds/defeatSoundEffect.wav"));
            sounds.put("heart", new SoundClip("data/generalSounds/heartSoundEffect.wav"));
            sounds.put("playerDamage", new SoundClip("data/generalSounds/playerDamageSoundEffect.wav"));
            sounds.put("victory", new SoundClip("data/generalSounds/victorySoundEffect.wav"));

            // Pirate level specific sounds
            sounds.put("coin", new SoundClip("data/pirateTheme/coinSoundEffect.wav"));
            sounds.put("pirateBackgroundTrack", new SoundClip("data/pirateTheme/pirateBackgroundTrack.wav"));
            sounds.put("treasureChest", new SoundClip("data/pirateTheme/treasureChestSoundEffect.wav"));

            // Space level specific sounds
            sounds.put("alienDamage", new SoundClip("data/spaceTheme/alienDamageSoundEffect.wav"));
            sounds.put("ammo", new SoundClip("data/spaceTheme/ammoSoundEffect.wav"));
            sounds.put("gravityBoots", new SoundClip("data/spaceTheme/gravityBootsSoundEffect.wav"));
            sounds.put("moon", new SoundClip("data/spaceTheme/moonSoundEffect.wav"));
            sounds.put("pewpew", new SoundClip("data/spaceTheme/pewpewSoundEffect.wav"));
            sounds.put("spaceBackgroundTrack", new SoundClip("data/spaceTheme/spaceBackgroundTrack.wav"));
            sounds.put("star", new SoundClip("data/spaceTheme/starSoundEffect.wav"));

            // Magic level specific sounds
            sounds.put("book", new SoundClip("data/magicTheme/bookPickupSoundEffect.wav"));
            sounds.put("enemyWizardDamage", new SoundClip("data/magicTheme/enemyWizardDamageSoundEffect.wav"));
            sounds.put("fireballPickup", new SoundClip("data/magicTheme/fireballPickupSoundEffect.wav"));
            sounds.put("fireballShooting", new SoundClip("data/magicTheme/fireballShootingSoundEffect.wav"));
            sounds.put("magicBackgroundTrack", new SoundClip("data/magicTheme/magicBackgroundTrack.wav"));
            sounds.put("portal", new SoundClip("data/magicTheme/portalSoundEffect.wav"));
            sounds.put("potion", new SoundClip("data/magicTheme/potionHittingSoundEffect.wav"));
        }
        catch (IOException | UnsupportedAudioFileException | LineUnavailableException e) {
            System.out.println("Error loading sounds: " + e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * Plays the sound associated with the given name once.
     *
     * @param name the key associated with the sound to be played
     */
    public static void play(String name) {
        SoundClip clip = sounds.get(name);
        if (clip != null) {
            clip.play();
        } else {
            System.out.println("Sound not found: " + name);
        }
    }

    /**
     * Loops the sound associated with the given name continuously.
     *
     * @param name the key associated with the sound to be looped
     */
    public static void loop(String name) {
        SoundClip clip = sounds.get(name);
        if (clip != null) {
            clip.loop();
        } else {
            System.out.println("Sound not found: " + name);
        }
    }

    /**
     * Stops the sound associated with the given name if it is currently playing.
     *
     * @param name the key associated with the sound to be stopped
     */
    public static void stop(String name) {
        if (name == null) {
            return; // Nothing to stop
        }
        SoundClip clip = sounds.get(name);
        if (clip != null) {
            clip.stop();
        } else {
            System.out.println("Sound not found: " + name);
        }
    }
}