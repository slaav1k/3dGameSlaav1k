package components;

import com.badlogic.ashley.core.Component;

public class PlayerComponent implements Component {
    public float health;
    public static int score;
    public PlayerComponent() {
        health = 10;
        score = 0;
    }
}
