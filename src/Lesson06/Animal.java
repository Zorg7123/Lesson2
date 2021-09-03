package Lesson06;

abstract class Animal {
    private double limitRun;
    private double limitSwim;
    private double limitJump;

    Animal(double limitRun, double limitSwim, double limitJump) {
        this.limitRun = limitRun;
        this.limitSwim = limitSwim;
        this.limitJump = limitJump;
    }

    public boolean run(double distance){
        return distance <= limitRun;
    }

    public boolean swim(double distance){
        return distance <= limitSwim;
    }
    public boolean jump(double height){
        return height <= limitJump;
    }

    public void setLimitRun(double limitRun) {
        this.limitRun = limitRun;
    }

    public void setLimitSwim(double limitSwim) {
        this.limitSwim = limitSwim;
    }

    public void setLimitJump(double limitJump) {
        this.limitJump = limitJump;
    }
}

class Cat extends Animal {
    Cat() {
        super(200, -1, 2);
    }
}

class Dog extends Animal {
    Dog() {
        super(500, 10, 0.5);
    }
}
