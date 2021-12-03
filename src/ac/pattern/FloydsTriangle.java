package ac.pattern;

public class FloydsTriangle {
    public static void main(String[] args) {
        int n = 5;
        int number = 1;
        for (int i = 5; i >= 0; --i) {
            for (int j = 1; j <= n - i; ++j) {
                System.out.print(number + " ");
                number++;
            }
            System.out.println();
        }
    }
}
