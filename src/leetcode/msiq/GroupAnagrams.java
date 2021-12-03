package leetcode.msiq;

import java.util.*;

/*
https://leetcode.com/problems/group-anagrams/
Time limit exceeded.
Runtime: 5 ms, faster than 99.65% of Java online submissions for Group Anagrams.
Memory Usage: 42.3 MB, less than 67.94% of Java online submissions for Group Anagrams.
 */

class GroupAnagrams {
    public static void main(String[] args) {
        GroupAnagrams obj = new GroupAnagrams();
        String[] strs1 = {"eat", "tea", "tan", "ate", "nat", "bat"};
        String[] strs2 = {"a"};
        String[] strs3 = {""};

        System.out.println(obj.groupAnagrams(strs1));
        System.out.println(obj.groupAnagrams(strs2));
        System.out.println(obj.groupAnagrams(strs3));
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        if (strs.length == 0) {
            return result;
        }

        List<String> uniqueSortedValue = new ArrayList<>();
        for (int i = 0; i < strs.length; i++) {
            char charArray[] = strs[i].toCharArray();
            Arrays.sort(charArray);
            String value = new String(charArray);

            if (!uniqueSortedValue.contains(value)) {
                uniqueSortedValue.add(value);
            }
        }

        for (int i = 0; i < uniqueSortedValue.size(); i++) {
            List<String> group = new ArrayList<>();
            for (int j = 0; j < strs.length; j++) {
                char charArray[] = strs[j].toCharArray();
                Arrays.sort(charArray);
                String value = new String(charArray);
                if (uniqueSortedValue.get(i).equals(value)) {
                    group.add(strs[j]);
                }

            }
            result.add(group);
        }

        return result;
    }

    public List<List<String>> groupAnagramsOptimized(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        if (strs.length == 0) {
            return result;
        }

        HashMap<String, List<String>> hm = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            char charArray[] = strs[i].toCharArray();
            Arrays.sort(charArray);
            String value = new String(charArray);
            List<String> valueLst = hm.get(value);
            if (valueLst == null) {
                valueLst = new ArrayList<>();
                hm.put(value, valueLst);
            }

            valueLst.add(strs[i]);
        }

        for (Map.Entry<String, List<String>> entry : hm.entrySet()) {
            List<String> resultGroup = entry.getValue();
            result.add(resultGroup);
        }
        return result;
    }
}