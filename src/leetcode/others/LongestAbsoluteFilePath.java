package leetcode.others;

import java.util.HashMap;
import java.util.Map;

class LongestAbsoluteFilePath {
    public static void main(String[] args) {
        LongestAbsoluteFilePath obj = new LongestAbsoluteFilePath();
        String s = "dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext";
        System.out.println(obj.lengthLongestPath(s));
    }

    public int lengthLongestPath(String input) {
        int length = 0;
        Map<Integer, String> map = new HashMap<>();
        String[] lines = input.split("\n");

        for (String line : lines) {
            String[] tabSplit = line.split("\t");
            String lastValue = tabSplit[tabSplit.length - 1];
            int tabCount = tabSplit.length - 1;
            map.put(tabCount, lastValue);
            if (lastValue.contains(".")) {
                length = Math.max(length, getLength(map, tabCount));
            }
        }

        return length;
    }

    public int getLength(Map<Integer, String> map, int limit) {
        int length = 0;
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            if (entry.getKey() <= limit) {
                length += entry.getValue().length();
            }
        }
        return length + limit;
    }
}