package com.yuanhy.string;

public class Point {
    public double x;
    public double y;

    public void clear() {
        this.x = 0.0;
        this.y = 0.0;
    }

    public void move(double x, double y) {
        this.x = x;
        this.y = y;
    }
}
