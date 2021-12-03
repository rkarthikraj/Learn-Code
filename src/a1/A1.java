package a1;

import java.io.IOException;

public class A1 {
    public static void main(String[] args) throws IOException {
        int nums = 153;
        while (nums > 0) {
            int n = nums % 10;
            nums /= 10;
            System.out.println(n);
        }
    }
}
