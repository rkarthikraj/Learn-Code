package leetcode.curator;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

class WordDistance {
    Map<String, List<Integer>> wordDictHM = new HashMap<>();

    public WordDistance(String[] wordsDict) {
        for (int i = 0; i < wordsDict.length; i++) {
            List<Integer> list = wordDictHM.get(wordsDict[i]);
            if(list == null) {
                list = new LinkedList<>();
                wordDictHM.put(wordsDict[i], list);
            }
            list.add(i);
        }

        System.out.println(wordDictHM);
    }

    public int shortest(String word1, String word2) {
        List<Integer> position1 = wordDictHM.get(word1);
        List<Integer> position2 = wordDictHM.get(word2);

        int min = Integer.MAX_VALUE;

//        for (int i = 0; i < position1.size(); i++) {
//            for (int j = 0; j < position2.size(); j++) {
//                int result = Math.abs(position2.get(j) - position1.get(i));
//                min = Math.min(min, result);
//            }
//        }

        for(int i = 0, j = 0; i < position1.size() && j < position2.size(); ) {
            int index1 = position1.get(i), index2 = position2.get(j);
            if(index1 < index2) {
                min = Math.min(min, index2 - index1);
                i++;
            } else {
                min = Math.min(min, index1 - index2);
                j++;
            }
        }

        return min;
    }

    public static void main(String[] args) {
        WordDistance obj = null;

        String[] operations = {"WordDistance", "shortest", "shortest"};
        String[][] values = {{"a","a","b","b"}, {"a", "b"}, {"b", "a"}};

        for (int i = 0; i < values.length; i++) {
            String operation = operations[i];

            switch (operation) {
                case "WordDistance":
                    obj = new WordDistance(values[i]);
                    break;
                case "shortest":
                    System.out.println(obj.shortest(values[i][0], values[i][1]));
                    break;
            }
        }
    }
}

/**
 * Your WordDistance object will be instantiated and called as such:
 * WordDistance obj = new WordDistance(wordsDict);
 * int param_1 = obj.shortest(word1,word2);
 */