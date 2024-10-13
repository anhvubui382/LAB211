
import java.util.Scanner;

public class Circle implements Shape {
    private double radius;

    public Circle() {
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        if (radius <= 0) {
            throw new IllegalArgumentException("Radius must be greater than 0");
        }
        this.radius = radius;
    }

    @Override
    public void printResult() {
        System.out.println("----Circle----");
        System.out.println("Radius: " + radius);
        System.out.println("Area: " + Area());
        System.out.println("Circumference: " + Perimeter());
    }

    @Override
    public double Area() {
        return Math.PI * radius * radius;
    }

    @Override
    public double Perimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public void Input() {
        Scanner in = new Scanner(System.in);
        try {
            System.out.println("Please input radius: ");
            double r = in.nextDouble();
            setRadius(r);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}