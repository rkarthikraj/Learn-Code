package alogs.recurrsion;

public class DecimalToBinary {
    public static void main(String[] args) {
        DecimalToBinary obj = new DecimalToBinary();
        int decimal = 233;
        System.out.println(obj.findBinary(decimal, ""));
    }

    public String findBinary(int decimal, String result) {
        if (decimal == 0) {
            return result;
        }

        result = decimal % 2 + result;
        return findBinary(decimal / 2, result);
    }
}
