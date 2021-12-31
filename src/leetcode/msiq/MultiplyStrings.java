package leetcode.msiq;

class MultiplyStrings {
    public static void main(String[] args) {
        MultiplyStrings obj = new MultiplyStrings();
        System.out.println(obj.multiply("123456789", "987654321"));
    }

    public String multiply(String num1, String num2) {
        int result = Integer.parseInt(num1) * Integer.parseInt(num2);

        return result + "";
    }
}