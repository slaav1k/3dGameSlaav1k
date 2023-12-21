package UI;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.deeep.spaceglad.Assets;
import com.deeep.spaceglad.Core;
import com.deeep.spaceglad.FilesCore;
import com.deeep.spaceglad.Settings;
import components.PlayerComponent;
import screens.GameScreen;
import screens.LeaderboardsScreen;
import screens.MainMenuScreen;


public class GameOverWidget extends Actor {
    private Core game;
    private Stage stage;
    private Image image;
    private TextButton retryB, leaderB, quitB, quitMenuB;

    public GameOverWidget(Core game, Stage stage) {
        this.game = game;
        this.stage = stage;
        setWidgets();
        setListeners();
    }

    private void setWidgets() {
        image = new Image(new Texture(Gdx.files.internal("data/gameOver.png")));
        retryB = new TextButton("Retry", Assets.skin);
        leaderB = new TextButton("Leaderboards", Assets.skin);
        quitB = new TextButton("Quit", Assets.skin);
        quitMenuB = new TextButton("Menu", Assets.skin);
    }

    private void setListeners() {
        retryB.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                game.setScreen(new GameScreen(game));
            }
        });
        leaderB.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                game.setScreen(new LeaderboardsScreen(game));
            }
        });
        quitB.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                Gdx.app.exit();
            }
        });
        quitMenuB.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent inputEvent, float x,
                                float y) {
                game.setScreen(new MainMenuScreen(game));
            }
        });
    }

    @Override
    public void setPosition(float x, float y) {
        super.setPosition(0, 0);
        image.setPosition(x, y + 32);
        retryB.setPosition(x - 110, y - 96);
        leaderB.setPosition(x + retryB.getWidth() - 90, y - 96);
        quitMenuB.setPosition(x + retryB.getWidth() + leaderB.getWidth() - 70, y - 96);
        quitB.setPosition(x + retryB.getWidth() + leaderB.getWidth() + quitMenuB.getWidth() - 50, y - 96);
    }

    @Override
    public void setSize(float width, float height) {
        super.setSize(Core.VIRTUAL_WIDTH, Core.VIRTUAL_HEIGHT);
        image.setSize(width, height);
        retryB.setSize(width / 2.5f, height / 2);
        leaderB.setSize(width / 2.5f, height / 2);
        quitMenuB.setSize(width / 2.5f, height / 2);
        quitB.setSize(width / 2.5f, height / 2);
    }

    public void gameOver() {
        stage.addActor(image);
        stage.addActor(retryB);
        stage.addActor(leaderB);
        stage.addActor(quitMenuB);
        stage.addActor(quitB);
        stage.unfocus(stage.getKeyboardFocus());
        Gdx.input.setCursorCatched(false);
        FilesCore.sendScore(PlayerComponent.score);
    }
}