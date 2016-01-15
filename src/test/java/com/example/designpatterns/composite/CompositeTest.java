package com.example.designpatterns.composite;

import com.example.designpatterns.composite.impl.Circle;
import com.example.designpatterns.composite.impl.CompositeShape;
import com.example.designpatterns.composite.impl.Square;
import org.junit.Test;

public class CompositeTest {

    @Test
    public void testCompositeShapes() throws Exception {
        Shape circle = new Circle(0, 0, 1);
        Shape square = new Square(10, 10, 5);
        CompositeShape composite = new CompositeShape();
        composite.addShape(circle);
        composite.addShape(square);
        circle.draw();
        square.draw();
        composite.draw();
    }
}
