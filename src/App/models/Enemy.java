package App.models;

import App.Tools;

/**
 * Created by Aleksandr Gladkov [Anticisco]
 * Date: 04.09.2021
 */

public class Enemy {

    private int health;
    private int attackPoint;

    private int valueMin = 5;
    private int valueMax = 10;

    public Enemy() {
        this.health = Tools.randomRange(valueMin, valueMax);
        this.attackPoint = Tools.randomRange(valueMin, valueMax);
    }

    public void decreaseHealth(int value) {
        this.health -= value;
    }

    public int getHealth() {
        return health;
    }

    public int getAttackPoint() {
        return attackPoint;
    }
}
