package com.deeep.spaceglad;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Sound;

public class Sounds {
    static AssetManager assetManager = new AssetManager();
    public static Sound gunshotSound;
    public static Sound jumpSound;
    public static Sound spaceSound;
    public static Sound musicGameSound;

    public static Sound monsterDeathSound;
    public static Sound minusHPSound;
    public static Sound menuSound;
    public static Sound monsterSound;
    public static boolean isMusicPaused = true;
    public static boolean isMenuMusicPaused = true;
    public static boolean isMonsterMusicPaused = true;
    static boolean isStartPlay = false;

    public static void loadSounds() {
        assetManager.load("sounds/jump.mp3", Sound.class);
        assetManager.load("sounds/gunshot.mp3", Sound.class);
        assetManager.load("sounds/space.mp3", Sound.class);
        assetManager.load("sounds/musicGame.mp3", Sound.class);
        assetManager.load("sounds/monsterDeath.mp3", Sound.class);
        assetManager.load("sounds/minusHP.mp3", Sound.class);
        assetManager.load("sounds/menu.mp3", Sound.class);
        assetManager.load("sounds/monster.mp3", Sound.class);
        assetManager.finishLoading();
        jumpSound = assetManager.get("sounds/jump.mp3", Sound.class);
        gunshotSound = assetManager.get("sounds/gunshot.mp3", Sound.class);
        spaceSound = assetManager.get("sounds/space.mp3", Sound.class);
        musicGameSound = assetManager.get("sounds/musicGame.mp3", Sound.class);
        monsterDeathSound = assetManager.get("sounds/monsterDeath.mp3", Sound.class);
        minusHPSound = assetManager.get("sounds/minusHP.mp3", Sound.class);
        menuSound = assetManager.get("sounds/menu.mp3", Sound.class);
        monsterSound = assetManager.get("sounds/monster.mp3", Sound.class);
        if (!isStartPlay) {
            long musicGameSoundId = Sounds.musicGameSound.play();
            Sounds.musicGameSound.setLooping(musicGameSoundId, true);
            musicGameSound.pause();
            long menuSoundId = Sounds.menuSound.play();
            Sounds.menuSound.setLooping(menuSoundId, true);
            menuSound.pause();
            long monsterSoundId = Sounds.monsterSound.play();
            Sounds.musicGameSound.setLooping(monsterSoundId, true);
            monsterSound.pause();
            isStartPlay = true;
        }



    }

}
