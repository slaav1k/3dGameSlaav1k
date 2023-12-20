package components;

import com.badlogic.ashley.core.Component;

public class PlayerComponent implements Component {
    public float energy;
    public float oxygen;
    public float health;
    public static int score;
    public PlayerComponent() {
        energy = 100;
        oxygen = 100;
        health = 100;
        score = 0;
    }
}
