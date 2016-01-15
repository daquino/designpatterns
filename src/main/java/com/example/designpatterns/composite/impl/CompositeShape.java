package com.example.designpatterns.composite.impl;

import com.example.designpatterns.composite.Shape;

import java.util.ArrayList;
import java.util.List;

public class CompositeShape implements Shape {
    private List<Shape> shapes;

    public CompositeShape() {
        this.shapes = new ArrayList<>();
    }

    public void addShape(Shape shape) {
        shapes.add(shape);
    }

    @Override
    public void draw() {
        System.out.println("Starting composite drawing...");
        shapes.stream()
                .forEach(Shape::draw);
    }
}
