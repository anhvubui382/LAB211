/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author anhvu
 */
public class Fibonacci {
    private int[] fiboArray;
    
    public Fibonacci(int n){
        setFiboArray(n);
        generateFibo();
    }
    private void generateFibo(){
        if(fiboArray.length > 0){
            fiboArray[0] = 0;
        }
        if(fiboArray.length > 1){
            fiboArray[1] = 1;
        }
        for(int i = 2 ; i< fiboArray.length; i++){
            fiboArray[i] = fiboArray[i-1] + fiboArray[i-2];
        }
    }
    
    public void printFibo(){
        for(int i = 0; i < fiboArray.length; i++){
            System.out.println(fiboArray[i] + " ");
        }
    }
    public int[] getFiboArray() {
        return fiboArray;
    }

    public void setFiboArray(int n) {
       fiboArray = new int[n];
       
        generateFibo();
    }
    
}
