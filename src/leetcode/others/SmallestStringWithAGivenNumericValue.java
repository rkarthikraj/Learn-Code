package leetcode.others;

class SmallestStringWithAGivenNumericValue {
    public static void main(String[] args) {
        SmallestStringWithAGivenNumericValue obj = new SmallestStringWithAGivenNumericValue();

        System.out.println(obj.getSmallestString(3, 27));
        System.out.println(obj.getSmallestString(5, 73));
        System.out.println(obj.getSmallestString(5, 52));
    }

    public String getSmallestString(int n, int k) {
        char[] chArr = new char[n];

        while (n > 0) {
            int remainingValue = k - (n - 1);
            if (remainingValue > 26) {
                remainingValue = 26;
            }

            char ch = (char) (96 + remainingValue);
            chArr[n - 1] = ch;
            k = k - remainingValue;
            n--;
        }

        return String.valueOf(chArr);
    }
}


//        while (n > 0) {
//                int remainingValue = k - (n - 1);
//                if (remainingValue > 26) {
//                //sb.append("z");
//                //k = k - 26;
//                remainingValue = 26;
//                }
//                // else
//                char ch = (char) (96 + remainingValue);
//                sb.append(ch);
//                k = k - remainingValue;
//                // }
//                n--;
//                }