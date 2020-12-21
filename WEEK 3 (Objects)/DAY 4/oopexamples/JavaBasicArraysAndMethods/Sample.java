package JavaBasicArraysAndMethods;

import java.util.Scanner;

public class Sample {
  static double a = 0;
  static double b = 0;
   static void getInput()
   {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter a number : ");
    a = sc.nextDouble();
    System.out.println("Enter a number : ");
    b = sc.nextDouble();
   }

    static double calculateSqroot(double x)
   {
    return Math.sqrt(x);
   }
    static double calculateFormula(double a,double b)
   {
    return Math.sqrt(Math.pow(a, 2) + Math.pow(b,2));
   }

   static void printResult(double result)
   {
    System.out.println("The result is : "+result);
   }
   static int addition(int[] arr)
   {
       int sum = 0;
       for(int i =0;i<arr.length;i++)
       {
            sum = arr[i]+sum;
       }
        
       return sum;
   }
    public static void main(String[] args) {
          
        getInput();
        double sqrtOfA = calculateSqroot(a);
        printResult(sqrtOfA);
        double sqrtOfB = calculateSqroot(b);
        printResult(sqrtOfB);
        double result =  calculateFormula(a,b);
        printResult(result);
        //declare and initialize
        int arr[] = {10,20,20,50};
        int sum = addition(arr);
        printResult(sum);

    }
   
}
