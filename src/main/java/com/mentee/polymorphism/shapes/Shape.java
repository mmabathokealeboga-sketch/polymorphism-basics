package com.mentee.polymorphism.shapes;

/**
 * Abstract class demonstrating abstract and concrete methods
 */
public abstract class Shape {

    protected String name;
    protected String color;

    // TODO: Create a constructor that takes name and color
    public Shape(String name,String color){
        this.name= name;
        this.color = color;
    }

    // Abstract methods (must be implemented by subclasses)
    public abstract double calculateArea();
    public abstract double calculatePerimeter();

    // Concrete method (already implemented)
    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public void describe() {
        System.out.println("Shape: " + name + ", Color: " + color);
        System.out.println("Area: " + calculateArea());
        System.out.println("Perimeter: " + calculatePerimeter());
    }
}