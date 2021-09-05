package App.models;

import javax.imageio.ImageIO;

/**
 * Created by Aleksandr Gladkov [Anticisco]
 * Date: 04.09.2021
 */

public class Player {

    private int x;
    private int y;
    private int health;
    private int attackPoint;

    public Player() {
        this.health = 100;
        this.attackPoint = 10;
    }

//    public Player(int x, int y) {
//        this.health = 100;
//        this.attackPoint = 10;
//        setPosition(x, y);
//    }

    public void setPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void decreaseHealth(int value) {
        this.health -= value;
    }

    public void moveUp(){
        this.y -= 1;
    }

    public void moveLeft(){
        this.x -= 1;
    }

    public void moveRight(){
        this.x += 1;
    }

    public void moveDown(){
        this.y += 1;
    }

    public boolean isAlive() {
        return health > 0;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getHealth() {
        return health;
    }

    public int getAttackPoint() {
        return attackPoint;
    }

    public String getMyCoordinates() {
        return (x + 1) + ":" + (y + 1);
    }
}
