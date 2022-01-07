package leetcode.ds1;

import java.util.Arrays;

class FloodFill {
    public static void main(String[] args) {
        FloodFill obj = new FloodFill();
        int[][] image = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
        int sr = 1;
        int sc = 1;
        int newColor = 2;

        System.out.println(Arrays.deepToString(obj.floodFill(image, sr, sc, newColor)));
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image[sr][sc] == newColor) {
            return image;
        }

        fill(image, sr, sc, image[sr][sc], newColor);
        return image;
    }

    public void fill(int[][] image, int i, int j, int existingColor, int newColor) {
        if (i < 0 || i >= image.length || j < 0 || j >= image[i].length || image[i][j] != existingColor) {
            return;
        }

        image[i][j] = newColor;
        fill(image, i - 1, j, existingColor, newColor);
        fill(image, i + 1, j, existingColor, newColor);
        fill(image, i, j + 1, existingColor, newColor);
        fill(image, i, j - 1, existingColor, newColor);
    }
}