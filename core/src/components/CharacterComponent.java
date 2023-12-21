package components;

import com.badlogic.ashley.core.Component;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.physics.bullet.collision.btConvexShape;
import com.badlogic.gdx.physics.bullet.collision.btPairCachingGhostObject;
import com.badlogic.gdx.physics.bullet.dynamics.btKinematicCharacterController;


public class CharacterComponent implements Component {
    public btPairCachingGhostObject ghostObject;
    public btConvexShape ghostShape;
    public btKinematicCharacterController characterController;

    public Vector3 characterDirection = new Vector3();
    public Vector3 walkDirection = new Vector3();
}
