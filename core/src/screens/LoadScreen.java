package screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;

import com.badlogic.gdx.scenes.scene2d.actions.SequenceAction;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.utils.viewport.FitViewport;

import com.deeep.spaceglad.Assets;
import com.deeep.spaceglad.Core;
import com.deeep.spaceglad.Sounds;

public class LoadScreen implements Screen {
    private Core game;
    private Stage stage;
    Label label;
    private static float elapsedTime = 0;
    private Image backgroundImage;

    public LoadScreen(Core game) {
        this.game = game;
        stage = new Stage(new FitViewport(Core.VIRTUAL_WIDTH, Core.VIRTUAL_HEIGHT));
        setWidgets();
        configureWidgers();
        Gdx.input.setInputProcessor(stage);
        Sounds.loadSounds();
        if (Sounds.isMenuMusicPaused) {
            Sounds.menuSound.resume();
            Sounds.isMenuMusicPaused = false;
        }
    }

    private void configureWidgers() {
        backgroundImage.setSize(Core.VIRTUAL_WIDTH, Core.VIRTUAL_HEIGHT);
        backgroundImage.setColor(1, 1, 1, 0);
        backgroundImage.addAction(Actions.fadeIn(0.65f));
        stage.addActor(backgroundImage);
        label.setFontScale(3);
        label.setPosition(Core.VIRTUAL_HEIGHT / 4, Core.VIRTUAL_HEIGHT / 2);
        label.setColor(1, 1, 1, 0);
        label.addAction(new SequenceAction(Actions.delay(0.65f), Actions.fadeIn(0.75f)));
        stage.addActor(label);

    }

    private void setWidgets() {
        backgroundImage = new Image(new Texture(Gdx.files.internal("data/backgroundMN.png")));
        label = new Label("               Course work\n" + "Student: Vyacheslav Arkhipkin\n"
                + "Teacher: Alexander Mitroshin", Assets.skin);
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        elapsedTime += delta;
        if (elapsedTime >= 3) {
            game.setScreen(new MainMenuScreen(game));
        }
        stage.act(delta);
        stage.draw();
    }

    @Override
    public void resize(int width, int height) {
        stage.getViewport().update(width, height);
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
        stage.dispose();
    }
}
