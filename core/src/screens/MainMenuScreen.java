package screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.actions.SequenceAction;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.deeep.spaceglad.Assets;
import com.deeep.spaceglad.Core;
import com.deeep.spaceglad.Sounds;


public class MainMenuScreen implements Screen {
    private Core game;
    private Stage stage;
    private Image backgroundImage, titleImage;
    private TextButton playButton, leaderboardsButton, quitButton;

    public MainMenuScreen(Core game) {
        this.game = game;
        stage = new Stage(new FitViewport(Core.VIRTUAL_WIDTH, Core.VIRTUAL_HEIGHT));
        setWidgets();
        configureWidgers();
        setListeners();
        Gdx.input.setInputProcessor(stage);
        Sounds.loadSounds();
        if (Sounds.isMenuMusicPaused) {
            Sounds.menuSound.resume();
            Sounds.isMenuMusicPaused = false;
        }
    }

    private void setWidgets() {
        backgroundImage = new Image(new Texture(Gdx.files.internal("data/backgroundMN.png")));
        titleImage = new Image(new Texture(Gdx.files.internal("data/title.png")));
        playButton = new TextButton("Play", Assets.skin);
        leaderboardsButton = new TextButton("Leaderboards", Assets.skin);
        quitButton = new TextButton("Quit", Assets.skin);
    }

    private void configureWidgers() {
        backgroundImage.setSize(Core.VIRTUAL_WIDTH, Core.VIRTUAL_HEIGHT);
        backgroundImage.setColor(1, 1, 1, 0);
        backgroundImage.addAction(Actions.fadeIn(0.65f));
        titleImage.setSize(620, 200);
        titleImage.setPosition(Core.VIRTUAL_WIDTH / 2 - titleImage.getWidth() / 2, Core.VIRTUAL_HEIGHT / 2);
        titleImage.setColor(1, 1, 1, 0);
        titleImage.addAction(new SequenceAction(Actions.delay(0.65f), Actions.fadeIn(0.75f)));
        playButton.setSize(128, 64);
        playButton.setPosition(Core.VIRTUAL_WIDTH / 2 - playButton.getWidth() / 2, Core.VIRTUAL_HEIGHT / 2 - 100);
        playButton.setColor(1, 1, 1, 0);
        playButton.addAction(new SequenceAction(Actions.delay(0.65f), Actions.fadeIn(0.75f)));
        leaderboardsButton.setSize(128, 64);
        leaderboardsButton.setPosition(Core.VIRTUAL_WIDTH / 2 - playButton.getWidth() / 2, Core.VIRTUAL_HEIGHT / 2 - 170);
        leaderboardsButton.setColor(1, 1, 1, 0);
        leaderboardsButton.addAction(new SequenceAction(Actions.delay(0.65f), Actions.fadeIn(0.75f)));
        quitButton.setSize(128, 64);
        quitButton.setPosition(Core.VIRTUAL_WIDTH / 2 - playButton.getWidth() / 2, Core.VIRTUAL_HEIGHT / 2 - 240);
        quitButton.setColor(1, 1, 1, 0);
        quitButton.addAction(new SequenceAction(Actions.delay(0.65f), Actions.fadeIn(0.75f)));

        stage.addActor(backgroundImage);
        stage.addActor(titleImage);
        stage.addActor(playButton);
        stage.addActor(leaderboardsButton);
        stage.addActor(quitButton);
    }

    private void setListeners() {
        playButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                game.setScreen(new GameScreen(game));
                if (!Sounds.isMenuMusicPaused) {
                    Sounds.menuSound.pause();
                    Sounds.isMenuMusicPaused = true;
                }
            }
        });
        leaderboardsButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                game.setScreen(new LeaderboardsScreen(game));
            }
        });
        quitButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                Gdx.app.exit();
            }
        });
    }

    @Override
    public void render(float delta) {
        /** Updates */
        stage.act(delta);
        /** Draw */
        stage.draw();
    }

    @Override
    public void resize(int width, int height) {
        stage.getViewport().update(width, height);
    }

    @Override
    public void dispose() {
        stage.dispose();
    }

    @Override
    public void show() {
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
