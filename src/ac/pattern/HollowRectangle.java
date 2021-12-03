package ac.pattern;

public class HollowRectangle {
    public static void main(String[] args) {
        int row = 5;
        int column = 10;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (i == 0 || i == row - 1 || j == 0 || j == column - 1) {
                    System.out.print("\t*");
                } else {
                    System.out.print("\t");
                }
            }
            System.out.println();
        }
    }
}
