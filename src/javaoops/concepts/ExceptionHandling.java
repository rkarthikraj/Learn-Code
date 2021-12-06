package javaoops.concepts;

import java.util.Scanner;

class ExceptionHandling {
    public void divide(int num1, int num2) {
        String result = "";
        float output = num1 / num2;
        result = Float.toString(output);
        System.out.println("Result: " + result);
    }

    public static void main(String[] args) {

        Scanner objScanner = new Scanner(System.in);
        ExceptionHandling objExceptionDemo = new ExceptionHandling();

        System.out.println("Enter first number: ");
        int num1 = objScanner.nextInt();
        System.out.println("Enter second number: ");
        int num2 = objScanner.nextInt();
        try {
            objExceptionDemo.divide(num1, num2);
        } catch (Exception ex) {
            System.out.println("EXCEPTION: " + ex.toString());
        } finally {
            System.out.println("Finally Executed");
        }
    }
}
