package leetcode.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class DivideStringIntoGroups {
    public static void main(String[] args) {
        DivideStringIntoGroups obj = new DivideStringIntoGroups();
        String s = "abcdefghij";
        int k = 3;
        char fill = 'x';

        System.out.println(Arrays.toString(obj.divideString(s, k, fill)));
    }

    public String[] divideString(String s, int k, char fill) {
        List<String> list = new ArrayList<>();
        int counter = 0;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {

            if ((i % k) == 0) {
                if (sb.toString().trim().length() != 0) {
                    list.add(sb.toString());
                }
                sb = new StringBuilder();
                counter = 0;
            }

            char ch = s.charAt(i);
            if (counter < k) {
                sb.append(ch);
                counter++;
            }
        }

        counter = 0;
        if (sb.toString().length() != k) {
            int valueLength = sb.toString().length();
            int availableSpace = k - valueLength;

            while (counter < availableSpace) {
                sb.append(fill);
                counter++;
            }
            list.add(sb.toString());

        } else {
            list.add(sb.toString());
        }

        String[] result = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }

        return result;
    }
}