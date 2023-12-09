package com.deeep.spaceglad;

import com.badlogic.ashley.core.Engine;
import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.PerspectiveCamera;
import com.badlogic.gdx.graphics.VertexAttributes;
import com.badlogic.gdx.graphics.g3d.Environment;
import com.badlogic.gdx.graphics.g3d.Material;
import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.graphics.g3d.ModelBatch;
import com.badlogic.gdx.graphics.g3d.attributes.ColorAttribute;
import com.badlogic.gdx.graphics.g3d.attributes.FloatAttribute;
import com.badlogic.gdx.graphics.g3d.utils.ModelBuilder;
import com.badlogic.gdx.physics.bullet.Bullet;
import components.ModelComponent;
import managers.EntityFactory;
import systems.BulletSystem;
import systems.RenderSystem;

public class GameWorld {
    private static final float FOV = 67F;
    private ModelBatch modelBatch;
    private Environment environment;
    private PerspectiveCamera perspectiveCamera;
    private Engine engine;
    public BulletSystem bulletSystem;
    public ModelBuilder modelBuilder = new ModelBuilder();
    Model wallHorizontal = modelBuilder.createBox(40, 20, 1,
            new Material(ColorAttribute.createDiffuse(Color.WHITE),
                    ColorAttribute.createSpecular(Color.RED), FloatAttribute
                    .createShininess(16f)), VertexAttributes.Usage.Position
                    | VertexAttributes.Usage.Normal);
    Model wallVertical = modelBuilder.createBox(1, 20, 40,
            new Material(ColorAttribute.createDiffuse(Color.GREEN),
                    ColorAttribute.createSpecular(Color.WHITE),
                    FloatAttribute.createShininess(16f)),
            VertexAttributes.Usage.Position |
                    VertexAttributes.Usage.Normal);
    Model groundModel = modelBuilder.createBox(40, 1, 40,
            new Material(ColorAttribute.createDiffuse(Color.YELLOW),
                    ColorAttribute.createSpecular(Color.BLUE),
                    FloatAttribute.createShininess(16f)),
            VertexAttributes.Usage.Position
                    | VertexAttributes.Usage.Normal);


    public GameWorld(GameUI gameUI) {
        Bullet.init();
        initEnvironment();
        initModelBatch();
        initPersCamera();
        addSystems(gameUI);
        addEntities();
    }


    private void initPersCamera() {
        perspectiveCamera = new PerspectiveCamera(FOV,
                Core.VIRTUAL_WIDTH, Core.VIRTUAL_HEIGHT);
        perspectiveCamera.position.set(30f, 40f, 30f);
        perspectiveCamera.lookAt(0f, 0f, 0f);
        perspectiveCamera.near = 1f;
        perspectiveCamera.far = 300f;
        perspectiveCamera.update();
    }

    private void addEntities() {
        createGround();
    }

    private void createGround() {
        engine.addEntity(EntityFactory.createStaticEntity
                (groundModel,0, 0, 0));
        engine.addEntity(EntityFactory.createStaticEntity
                (wallHorizontal, 0, 10, -20));
        engine.addEntity(EntityFactory.createStaticEntity
                (wallHorizontal, 0, 10, 20));
        engine.addEntity(EntityFactory.createStaticEntity
                (wallVertical, 20, 10, 0));
        engine.addEntity(EntityFactory.createStaticEntity
                (wallVertical, -20, 10, 0));
    }

    private void addSystems() {
        engine = new Engine();
        engine.addSystem(new RenderSystem(modelBatch, environment));
        engine.addSystem(bulletSystem = new BulletSystem());
    }


    private void initEnvironment() {
        environment = new Environment();
        environment.set(new ColorAttribute(ColorAttribute.AmbientLight,
                0.3f, 0.3f, 0.3f, 1f));
    }

    private void initModelBatch() {
        modelBatch = new ModelBatch();
    }

    public void dispose() {
        bulletSystem.dispose();
        bulletSystem = null;
        wallHorizontal.dispose();
        wallVertical.dispose();
        groundModel.dispose();
        modelBatch.dispose();
        modelBatch = null;
    }


    public void resize(int width, int height) {
        perspectiveCamera.viewportHeight = height;
        perspectiveCamera.viewportWidth = width;
    }

    public void render(float delta) {
        renderWorld(delta);
    }

    protected void renderWorld(float delta) {
        modelBatch.begin(perspectiveCamera);
        engine.update(delta);
        modelBatch.end();
    }










}
