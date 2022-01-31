package leetcode.others;

class FindSubstringWithGivenHashValue {
    public static void main(String[] args) {
        FindSubstringWithGivenHashValue obj = new FindSubstringWithGivenHashValue();
        String s = "xmmhdakfursinye";
        // String s = "abcdefgh";
        int power = 96;
        int modulo = 45;
        int k = 15;
        int hashValue = 21;

        System.out.println(obj.subStrHash(s, power, modulo, k, hashValue));
    }


    public String subStrHash(String s, int power, int modulo, int k, int hashValue) {
        long[] powerValue = new long[k]; //to store all the power values beforehand to avoid redundant calculations

        for (int i = 0; i < k; i++) {
            powerValue[i] = calculatePower(power, i, modulo);
        }

        StringBuilder sb = new StringBuilder();
        int length = s.length();
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < k; j++) {
                if ((i + j) < length) {
                    char ch = s.charAt(i + j);
                    sb.append(ch);
                }
            }

            if (sb.toString().length() == k) {
                long sum = 0L;
                String subString = sb.toString();
                for (int idx = 0; idx < subString.length(); idx++) {
                    char ch = subString.charAt(idx);
                    long alphabetPosition = ch - 97 + 1;
                    sum += alphabetPosition * powerValue[idx];
                }

                long computedHashValue = sum % modulo;
                System.out.println("SubString: " + subString + ", Sum: " + sum + ", ComputedHasValue: " + computedHashValue);
                if (computedHashValue == hashValue) {
                    return subString;
                }
            }

            sb.delete(0, k);
        }

        return "";
    }

    public boolean isHashValueString(String subString, int power, int modulo, int hashValue) {
        long sum = 0L;
        for (int i = 0; i < subString.length(); i++) {
            char ch = subString.charAt(i);
            long alphabetPosition = ch - 97 + 1;
            sum += ((long) (alphabetPosition * (Math.pow(power, i) % modulo)));
        }

        long computedHashValue = sum % modulo;
        System.out.println("SubString: " + subString + ", Sum: " + sum + ", ComputedHasValue: " + computedHashValue);
        if (computedHashValue == hashValue) {
            return true;
        }
        return false;
    }

    private long calculatePower(long a, long b, long m) {
        a %= m;
        long res = 1;
        while (b > 0) {
            if (b % 2 == 1)
                res = res * a % m;
            a = a * a % m;
            b >>= 1;
        }
        return res;
    }
}