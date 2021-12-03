package optimize;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class OptimizeHashMap {
    public static void main(String... args) throws IOException {
        HashMap<Character, List<Integer>> hm = new HashMap<Character, List<Integer>>();

        String inputString = "HelloWorld";

        for (int i = 0; i < inputString.length(); ++i) {
            char c = inputString.charAt(i);
            List<Integer> list = hm.get(c);
            if (list == null) {
                list = new ArrayList();
                hm.put(c, list);
            }
            list.add(i);
        }
        System.out.println(hm);
    }
}
