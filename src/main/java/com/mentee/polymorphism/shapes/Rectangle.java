package com.mentee.polymorphism.shapes;



public class Rectangle extends Shape implements Drawable, Resizable {

    private double width;
    private double height;

    // TODO: Create constructor (name, color, width, height)

    // TODO: Implement all abstract methods from Shape, Drawable, and Resizable
    public Rectangle(String name, String color, double width,double height){
        super(name, color);
        this.width = width;
        this.height = height;
    }

    @Override
    public double calculateArea() {
        return width * height;
    }

    @Override
    public double calculatePerimeter() {
        return 2 * (width + height);
    }

    @Override
    public void draw() {
        System.out.println("Draw a rectangle with  width" + width + "and height" + height) ;
    }

    @Override
    public void resize(double factor) {
        this.height = height * factor;
        this.width = width * factor;
    }
}
