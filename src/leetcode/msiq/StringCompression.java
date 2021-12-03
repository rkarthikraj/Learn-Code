package leetcode.msiq;

/*
https://leetcode.com/problems/string-compression/
Runtime: 20 ms, faster than 5.68% of Java online submissions for String Compression.
Memory Usage: 40 MB, less than 33.20% of Java online submissions for String Compression.
 */

import java.util.*;

class StringCompression {
    public static void main(String[] args) {
        StringCompression obj = new StringCompression();
        char[] chars1 = {'a', 'a', 'b', 'b', 'c', 'c', 'c'};
        char[] chars2 = {'a'};
        char[] chars3 = {'a', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b'};
        char[] chars4 = {'a', 'a', 'a', 'b', 'b', 'a', 'a'};
        char[] chars5 = {'8', 'I', 'o', 'n', 'U', 'H', 'V', ',', '>', '<'};

        obj.compressOptimize(chars1);
        obj.compressOptimize(chars2);
        obj.compressOptimize(chars3);
        obj.compressOptimize(chars4);
        obj.compressOptimize(chars5);
    }

    public int compress(char[] chars) {
        Map<Character, Integer> hm = new HashMap<Character, Integer>();
        List<String> helper = new LinkedList<>();
        char previousChar = ' ';
        char currentChar = ' ';

        for (int i = 0; i < chars.length; i++) {
            currentChar = chars[i];
            if (hm.containsKey(currentChar)) {
                hm.put(currentChar, hm.get(currentChar).intValue() + 1);
            } else {
                if (previousChar != ' ' && previousChar != currentChar) {
                    helper.add(previousChar + "\t" + hm.get(previousChar));
                    hm.remove(previousChar);
                }
                hm.put(currentChar, 1);
                previousChar = currentChar;
            }
        }

        if (hm.containsKey(currentChar)) {
            helper.add(currentChar + "\t" + hm.get(currentChar));
            hm.remove(currentChar);
        }

        System.out.println(helper);

        int index = 0;
        for (int i = 0; i < helper.size(); i++) {
            String[] listValue = helper.get(i).split("\t");
            char key = listValue[0].charAt(0);
            int value = Integer.parseInt(listValue[1]);

            chars[index] = key;
            if (value > 1 && value < 10) {
                chars[++index] = (char) (value + '0');
            } else if (value >= 10) {
                String number = String.valueOf(value);
                for (int j = 0; j < number.length(); j++) {
                    int k = Character.digit(number.charAt(j), 10);
                    chars[++index] = (char) (k + '0');
                }
            }
            index++;
        }

        System.out.println(Arrays.toString(chars) + " - " + index);
        return index;
    }


    public int compressOptimize(char[] chars) {
        int index = 0;
        int i = 0;

        while (i < chars.length) {
            int j = i;
            while (j < chars.length && chars[j] == chars[i]) {
                j++;
            }

            chars[index++] = chars[i];
            if (j - i > 1) {
                String count = j - i + "";
                for (char c : count.toCharArray()) {
                    chars[index++] = c;
                }
            }
            i = j;
        }
        return index;
    }
}