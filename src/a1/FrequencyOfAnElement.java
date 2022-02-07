package a1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FrequencyOfAnElement {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 3, 3, 4, 5, 6, 7, 3, 3, 7, 6, 5};
        int target = 3;
        Map<Integer, List<Integer>> hm = new HashMap<>();

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == target) {
                List<Integer> listValue = hm.get(numbers[i]);
                if (listValue == null) {
                    listValue = new ArrayList<>();
                    hm.put(numbers[i], listValue);
                }
                listValue.add(i);
            }
        }


        //        int[] numbers = {1, 2, 3, 3, 3, 4, 5, 6, 7, 3, 3, 7, 6, 5};
        //        for (int i = 0; i < numbers.length; i++) {
        //            if (hm.containsKey(numbers[i])) {
        //                List<Integer> list = hm.get(numbers[i]);
        //                list.add(i);
        //                hm.put(numbers[i], list);
        //            } else {
        //                List<Integer> list = new ArrayList<>();
        //                list.add(i);
        //                hm.put(numbers[i], list);
        //            }
        //        }

        System.out.println(hm.get(target));
    }
}
