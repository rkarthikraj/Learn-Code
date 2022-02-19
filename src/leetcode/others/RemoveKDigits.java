package leetcode.others;

/*
Not Working
 */
class RemoveKDigits {
    public static void main(String[] args) {
        RemoveKDigits obj = new RemoveKDigits();
        //        String num1 = "1432219";
        //        int k1 = 3;
        //        System.out.println(obj.removeKdigits(num1, k1));
        //
        //        String num2 = "10200";
        //        int k2 = 1;
        //        System.out.println(obj.removeKdigits(num2, k2));
        //
        //        String num3 = "10";
        //        int k3 = 2;
        //        System.out.println(obj.removeKdigits(num3, k3));

        String num4 = "10001";
        int k4 = 4;
        System.out.println(obj.removeKdigits(num4, k4));
    }

    public String removeKdigits(String num, int k) {
        String result = "";
        int length = num.length();

        if (length == k) {
            return "0";
        }

        int i = 0;
        while (k > 0) {
            i = (i > 0) ? (i - 1) : 0;
            while (i < length - 1 && num.charAt(i) <= num.charAt(i + 1)) {
                i++;
            }
            num = num.substring(0, i) + num.substring(i + 1);
            k--;
        }

        if (num.length() == 0) {
            return "0";
        }

        int value = Integer.parseInt(num);
        result = Integer.toString(value);

        return result;
    }
}


/*
public String removeKdigits(String num, int k) {
        String result = "";
        int length = num.length();
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < length; i++) {
            int counter = k;
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < length; j++) {
                if (j == i) {
                    while (counter > 0) {
                        j++;
                        counter--;
                    }
                }
                if (j < length) {
                    sb.append(num.charAt(j));
                }
            }

            //System.out.println(sb.toString());
            if (sb.length() == (length - k)) {
                int value = 0;
                if (!sb.toString().equals("")) {
                    value = Integer.parseInt(sb.toString());
                }
                min = Math.min(min, value);
            }
        }

        result = Integer.toString(min);
        return result;
    }
 */