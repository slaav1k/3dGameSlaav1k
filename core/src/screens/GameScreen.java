package screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.deeep.spaceglad.Core;

public class GameScreen implements Screen {
    Core game;
    GameWorld gameWorld;

    public GameScreen(Core game) {
        this.game = game;
        gameWorld = new GameWorld();
        Gdx.input.setCursorCatched(true);
    }
    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        gameWorld.render(delta);
    }

    @Override
    public void resize(int width, int height) {
        gameWorld.resize(width, height);
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

    @Override
    public void dispose() {
        gameWorld.dispose();
    }
}
