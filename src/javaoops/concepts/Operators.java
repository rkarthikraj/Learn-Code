package javaoops.concepts;

import java.io.IOException;

public class Operators {
    public static void main(String args[]) throws IOException {
        int a = 0;
        System.out.print("A >> " + a);
        int b = a++;
        System.out.print("\nB = A++ >> " + b);
        System.out.print("\nA >> " + a);

        int c = 0;
        System.out.print("\nC >> " + c);
        int d = ++c;
        System.out.print("\nD = ++C >> " + d);
        System.out.print("\nC >> " + c);
    }
}
