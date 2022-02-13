package leetcode.others;

import java.util.HashMap;
import java.util.Map;

/*
Not yet solved.
 */
class LongestAbsoluteFilePath {
    public static void main(String[] args) {
        LongestAbsoluteFilePath obj = new LongestAbsoluteFilePath();
        String s = "dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext";
        System.out.println(obj.lengthLongestPath(s));
    }

    public int lengthLongestPath(String input) {
        int length = Integer.MIN_VALUE;
        String[] path = input.split("\n");
        Map<String, String> map = new HashMap<>();
        System.out.println(input);

        int previousTabCount = 0;
        String lineage = "";
        for (int i = 0; i < path.length; i++) {
            int tabCount = 0;
            while (path[i].charAt(tabCount) == '\t') {
                tabCount++;
            }

            if (tabCount != 0) {
                if (tabCount == previousTabCount) {
                    lineage += "";
                } else {
                    lineage += tabCount;
                }

                if (!map.containsKey(lineage)) {
                    map.put(lineage, path[i].substring(tabCount));
                } else {
                    map.put(lineage, map.get(lineage) + "," + path[i].substring(tabCount));
                }
                previousTabCount = tabCount;
            } else {
                map.put(tabCount + "", path[i]);
                lineage += tabCount;
            }
        }

        System.out.println(map);

        return length == Integer.MIN_VALUE ? 0 : length;
    }
}