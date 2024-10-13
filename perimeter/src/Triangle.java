
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author anhvu
 */
public class Triangle implements Shape {

    double a;
    double b;
    double c;

    public Triangle() {
    }

    public Triangle(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double getA() {
        return a;
    }

    public void setA(double a) {
        if (a <= 0) {
            throw new IllegalArgumentException("Side a must be > 0");
        }
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        if (b <= 0) {
            throw new IllegalArgumentException("Side b must be > 0");
        }
        this.b = b;
    }

    public double getC() {
        return c;
    }

    public void setC(double c) {
        if (c <= 0) {
            throw new IllegalArgumentException("Side c must be > 0");
        }
        this.c = c;
    }

    public boolean isTriangle() {
        if (a + b > c && b + c > a && a + c > b) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void printResult() {
        if (isTriangle()) {
            System.out.println("----Triangle----");
            System.out.println("Side a: " + a);
            System.out.println("Side b: " + b);
            System.out.println("Side c: " + c);
            System.out.println("Area: " + Area());
            System.out.println("Perimeter: " + Perimeter());
        } else {
            throw new IllegalArgumentException("Input side is not a rectangle");
        }
    }

    @Override
    public double Area() {
        if (isTriangle()) {
            double p = (a + b + c) / 2;
            return Math.sqrt(p * (p - a) * (p - b) * (p - c));
        } else {
            throw new IllegalArgumentException("Input side is not a rectangle");
        }
    }

    @Override
    public double Perimeter() {
        if (isTriangle()) {
            
            return a+b+c;
        } else {
            throw new IllegalArgumentException("Input side is not a rectangle");
        }
    }

    @Override
    public void Input() {
        Scanner in = new Scanner(System.in);
        try {
            System.out.println("Please side A: ");
            double a = in.nextDouble();
            setA(a);
            System.out.println("Please side B: ");
            double b = in.nextDouble();
            setB(b);
            System.out.println("Please side C: ");
            double c = in.nextDouble();
            setC(c);
            if (!isTriangle()) {
                throw new IllegalArgumentException("Input side is not a rectangle");
            }
        } catch (Exception e) {
            System.out.println("Invalid input");
        }
    }
}
