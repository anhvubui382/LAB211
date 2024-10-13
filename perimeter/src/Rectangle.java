
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author anhvu
 */
public class Rectangle implements Shape{
    double length;
    double width;

    public Rectangle() {
    }

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        if(width <= 0){
            throw new IllegalArgumentException("Length must be greater than 0");
        }
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        if(width <= 0){
            throw new IllegalArgumentException("Width must be greater than 0");
        }
        this.width = width;
    }
    
    @Override
    public void printResult() {
        System.out.println("----Rectangle----");
        System.out.println("Width: " + width);
        System.out.println("Length: " + length);
       
        System.out.println("Area: " + Area());
        System.out.println("Perimeter: " + Perimeter());
    }

    @Override
    public double Area() {
        return width * length;
       }

    @Override
    public double Perimeter() {
        return width + length;
    }

    @Override
    public void Input() {
       Scanner in = new Scanner(System.in);
       try{
           System.out.println("please input width: ");
           double a = in.nextDouble();
           setWidth(a);
           System.out.println("please input lenght: ");
           double b = in.nextDouble();
           setLength(b);
       } catch (Exception e){
           System.out.println(e.getMessage());
       }
    }
    
}
