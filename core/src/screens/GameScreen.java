package screens;

import UI.GameUI;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.deeep.spaceglad.Core;
import com.deeep.spaceglad.GameWorld;
import com.deeep.spaceglad.Settings;
import com.deeep.spaceglad.Sounds;

public class GameScreen implements Screen {
    Core game;
    GameUI gameUI;
    GameWorld gameWorld;

    public GameScreen(Core game) {
        this.game = game;
        gameUI = new GameUI(game);
        gameWorld = new GameWorld(gameUI);
        Settings.Paused = false;
        Gdx.input.setInputProcessor(gameUI.stage);
        Gdx.input.setCursorCatched(true);

        if (Sounds.isMusicPaused) {
            Sounds.musicGameSound.resume();
            Sounds.isMusicPaused = false;
        }


    }

    @Override
    public void show() {
    }

    @Override
    public void render(float delta) {
        gameUI.update(delta);
        gameWorld.render(delta);
        gameUI.render();
    }

    @Override
    public void resize(int width, int height) {
        gameUI.resize(width, height);
        gameWorld.resize(width, height);
    }

    @Override
    public void dispose() {
        gameWorld.dispose();
        gameUI.dispose();

    }

    @Override
    public void pause() {
    }

    @Override
    public void resume() {
    }

    @Override
    public void hide() {
    }
}
