package com.example.designpatterns.composite.impl;

import com.example.designpatterns.composite.Shape;

public class Square implements Shape {
    private int x;
    private int y;
    private int length;

    public Square(final int x, final int y, final int length) {
        this.x = x;
        this.y = y;
        this.length = length;
    }

    @Override
    public void draw() {
        System.out.println(String.format("Drawing a square starting at (%s, %s) with a length of %s", x, y, length));
    }
}
