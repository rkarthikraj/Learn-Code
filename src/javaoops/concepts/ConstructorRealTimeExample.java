package javaoops.concepts;

import java.io.IOException;

public class ConstructorRealTimeExample {
    int output;
    String status;

    ConstructorRealTimeExample() {
        output = 0;
        status = "Fatal";
    }

    public void divideByZeroException(int num1, int num2) {
        try {
            output = num1 / num2;
            status = "Success";
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        System.out.println(status + " --> " + output);
    }

    public static void main(String args[]) throws IOException {
        ConstructorRealTimeExample obj = new ConstructorRealTimeExample();
        obj.divideByZeroException(15, 2);
    }
}
