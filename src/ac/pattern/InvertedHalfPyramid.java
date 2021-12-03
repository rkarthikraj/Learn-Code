package ac.pattern;

public class InvertedHalfPyramid {
    public static void main(String[] args) {
        int row = 5;
        for (int i = row; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        System.out.println("----------------------------------");

        int n = 5;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n - i; ++j) {
                System.out.print(" ");
            }
            for (int j = 0; j <= i; ++j) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
