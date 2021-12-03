package optimize;

public class BinarySearchOverflow {
    public static void main(String[] args) {
        //int low = Integer.MAX_VALUE - 10;
        //int high = Integer.MAX_VALUE;

        int low = 0;
        int high = 10;

        System.out.println("Low: " + low);
        System.out.println("High: " + high);

        int sum = low + high;
        System.out.println("Low + High: " + sum);

        int hl = high - low;
        System.out.println("High - Low: " + hl);

        int mid = (low + hl) / 2;
        System.out.println("Mid: " + mid);
    }
}
