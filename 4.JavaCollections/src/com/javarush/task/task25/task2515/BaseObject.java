package com.javarush.task.task25.task2515;

public abstract class BaseObject {
    private double x;
    private double y;
    private double radius;
    private boolean isAlive;

    public BaseObject(double x, double y, double radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
        isAlive = true;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public void draw() {
    }

    public void move() {
    }

    public void die() {
        isAlive = false;
    }

    public boolean isIntersect(BaseObject o) {
        double dX = this.x - o.x;
        double dY = this.y - o.y;
        double result = Math.sqrt(dX * dX + dY * dY);

        if (result < Math.max(this.radius, o.radius)) return true;
        else return false;
    }
}
