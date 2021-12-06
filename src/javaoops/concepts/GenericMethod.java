package javaoops.concepts;

public class GenericMethod {
    public static <E> void printArray(E[] inputArray) {
        for (E element : inputArray) {
            System.out.print(" " + element);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Integer[] intArray = {1, 2, 3, 4, 5, 6, 7};
        Character[] charArray = {'H', 'E', 'L', 'L', 'O', '\0', 'W', 'O', 'R', 'L', 'D'};

        System.out.println("Integer Array: ");
        printArray(intArray);

        System.out.println("Character Array: ");
        printArray(charArray);
    }
}
