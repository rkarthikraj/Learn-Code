package leetcode.ds1;

import java.util.LinkedHashMap;
import java.util.Map;

class FirstUniqueCharacterInString {
    public static void main(String[] args) {
        FirstUniqueCharacterInString obj = new FirstUniqueCharacterInString();
        String s = "leetcode";
        System.out.println(obj.firstUniqChar(s));
    }

    public int firstUniqChar(String s) {
        Map<Character, Integer> hm = new LinkedHashMap<>();
        int n = s.length();

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            hm.put(c, hm.getOrDefault(c, 0) + 1);
        }

        System.out.println(hm);

        //        for (Map.Entry<Character, Integer> entry : hm.entrySet()) {
        //            if (entry.getValue() == 1) {
        //                return s.indexOf(entry.getKey());
        //            }
        //        }

        for (int i = 0; i < n; i++) {
            if (hm.get(s.charAt(i)) == 1)
                return i;
        }
        return -1;
    }
}