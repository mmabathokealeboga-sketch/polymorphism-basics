\package com.mentee.polymorphism.shapes;

public class Circle extends Shape implements Drawable, Resizable {

    private double radius;

    // TODO: Create constructor (name, color, radius)

    // TODO: Implement all abstract methods from Shape, Drawable, and Resizable

    // TODO: Override describe() if needed (optional)

    public Circle(String name,String color, double radius){
        super(name, color);
        this.radius = radius;
    }

    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }
    @Override
    public double calculatePerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public void draw() {
        System.out.println("Draw a circle with  radius" + radius);
    }

    @Override
    public void resize(double factor) {
        this.radius = radius * factor;
    }

    @Override
    public void describe() {
        super.describe();
        System.out.println("Radius:" + radius);
    }
<<<<<<< HEAD
    public  Double getRadius(){
=======
    public double getRadius(){
>>>>>>> a84aebd (finished the shapes class and did the notificacation and payment class)
        return radius;
    }
}
