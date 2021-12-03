package leetcode.easy;

/*
Not solved.
https://leetcode.com/problems/confusing-number/
 */
class ConfusingNumber {
    public static void main(String[] args) {
        ConfusingNumber obj = new ConfusingNumber();

        System.out.println(obj.confusingNumber(1));
        System.out.println(obj.confusingNumber(69));
        System.out.println(obj.confusingNumber(11));
        System.out.println(obj.confusingNumber(86));
        System.out.println(obj.confusingNumber(8000));
        System.out.println(obj.confusingNumber(150));
        System.out.println(obj.confusingNumber(25));
    }

    public boolean confusingNumber(int n) {
        StringBuilder sb = new StringBuilder();
        boolean isRotated = true;
        String number = Integer.toString(n);
        String processedNumber = processTrailingZeros(number);

        for (int i = 0; i < processedNumber.length(); i++) {
            char ch = processedNumber.charAt(i);
            switch (ch) {
                case '0':
                    sb.append("0");
                    break;

                case '1':
                    sb.append("1");
                    break;

                case '6':
                    sb.append("9");
                    break;

                case '8':
                    sb.append("8");
                    break;

                case '9':
                    sb.append("6");
                    break;

                default:
                    isRotated = false;
                    break;
            }
        }


        if (!sb.toString().isEmpty() && isRotated) {
            if (n == Integer.parseInt(sb.toString())) {
                return false;
            } else {
                return true;
            }
        }

        return false;
    }

    public String processTrailingZeros(String number) {
        for (int i = number.length() - 1; i >= 0; --i) {
            if (number.charAt(i) != '0') {
                return number.substring(0, i + 1);
            }
        }
        return number;
    }
}