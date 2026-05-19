package com.mentee.polymorphism.shapes;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ShapeTest {

    @Test
    void testCirclePolymorphism() {
        // Polymorphic reference: Shape reference to Circle object
        Shape circle = new Circle("Circle1", "Red", 5.0);

        assertEquals("Circle1", circle.getName());
        assertEquals("Red", circle.getColor());
        assertTrue(circle.calculateArea() > 0);
        assertTrue(circle.calculatePerimeter() > 0);
    }

    @Test
    void testRectanglePolymorphism() {
        Shape rectangle = new Rectangle("Rect1", "Blue", 4.0, 6.0);

        assertEquals(24.0, rectangle.calculateArea(), 0.001);
        assertEquals(20.0, rectangle.calculatePerimeter(), 0.001);
    }

    @Test
    void testPolymorphicBehavior() {
        Shape[] shapes = {
                new Circle("C1", "Red", 3.0),
                new Rectangle("R1", "Blue", 5.0, 10.0),
                new Circle("C2", "Green", 7.0)
        };

        for (Shape shape : shapes) {
            assertNotNull(shape.getName());
            assertNotNull(shape.getColor());
            assertTrue(shape.calculateArea() > 0);
            assertTrue(shape.calculatePerimeter() > 0);

            // Demonstrate runtime polymorphism
            shape.describe();
        }
    }

    @Test
    void testInterfacePolymorphism() {
        Drawable drawableCircle = new Circle("CircleX", "Yellow", 4.0);
        Resizable resizableRect = new Rectangle("RectX", "Purple", 2.0, 3.0);

        drawableCircle.draw();

        assertDoesNotThrow(() -> resizableRect.resize(2.0));
    }

    @Test
    void testDowncastingAndInstanceOf() {
        Shape shape = new Circle("TestCircle", "Orange", 10.0);

        assertTrue(shape instanceof Drawable);
        assertTrue(shape instanceof Resizable);
        assertTrue(shape instanceof Circle);

        if (shape instanceof Circle circle) {
            assertEquals(10.0, circle.getRadius(), 0.001); // assuming you add getRadius()
        }
    }

    @Test
    void testResizeBehavior() {
        Circle circle = new Circle("ResizableCircle", "Black", 5.0);
        double originalArea = circle.calculateArea();

        circle.resize(2.0); // double the size

        assertEquals(originalArea * 4, circle.calculateArea(), 0.001); // area scales with square of factor
    }
}