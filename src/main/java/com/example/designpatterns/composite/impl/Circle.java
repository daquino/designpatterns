package com.example.designpatterns.composite.impl;

import com.example.designpatterns.composite.Shape;

public class Circle implements Shape {
    private int x;
    private int y;
    private double radius;

    public Circle(final int x, final int y, final double radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    @Override
    public void draw() {
        System.out.println(String.format("Drawing a circle with center at (%s, %s) and radius %s", x, y, radius));
    }
}
