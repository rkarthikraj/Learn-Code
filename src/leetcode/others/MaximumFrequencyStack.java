package leetcode.others;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.TreeMap;

class MaximumFrequencyStack {
    Map<Integer, Integer> frequencyHM;
    TreeMap<Integer, Stack<Integer>> group;
    Stack<Integer> stack;

    public MaximumFrequencyStack() {
        frequencyHM = new TreeMap<>();
        group = new TreeMap<>();
        stack = new Stack<>();
    }

    public void push(int val) {
        int f = frequencyHM.getOrDefault(val, 0) + 1;
        frequencyHM.put(val, f);
        stack.push(val);
        group.computeIfAbsent(f, z-> new Stack()).push(val);
    }

    public int pop() {
        Map.Entry<Integer, Stack<Integer>> integerStackEntry = group.lastEntry();
        int poppedValue = integerStackEntry.getValue().pop();
        frequencyHM.put(poppedValue, frequencyHM.get(poppedValue) - 1);
        if (group.lastEntry().getValue().size() == 0) {
            group.pollLastEntry();
        }
        return poppedValue;
    }

    public static void main(String... args) {
        MaximumFrequencyStack obj = null;
        // /String[] operations = {"FreqStack", "push", "push", "push", "push", "push", "push", "pop", "pop", "pop", "pop"};
        // int[][] values = {{}, {5}, {7}, {5}, {7}, {4}, {5}, {}, {}, {}, {}};

        String[] operations = {"FreqStack", "push", "push", "push", "push", "pop", "pop", "push", "push", "push", "pop", "pop", "pop"};
        int[][] values = {{}, {1}, {1}, {1}, {2}, {}, {}, {2}, {2}, {1}, {}, {}, {}};
        for (int i = 0; i < values.length; i++) {
            String operation = operations[i];

            switch (operation) {
                case "FreqStack":
                    obj = new MaximumFrequencyStack();
                    break;
                case "push":
                    obj.push(values[i][0]);
                    break;
                case "pop":
                    System.out.println(obj.pop());
                    break;
            }
        }

        System.out.println("Count Map: " + obj.frequencyHM);
        System.out.println("Stack: " + obj.stack);
        System.out.println("Group Stack: " + obj.group);
    }

    class FreqStackSolution {
        Map<Integer, Integer> freq;
        Map<Integer, Stack<Integer>> group;
        int maxfreq;

        public FreqStackSolution() {
            freq = new HashMap();
            group = new HashMap();
            maxfreq = 0;
        }

        public void push(int x) {
            int f = freq.getOrDefault(x, 0) + 1;
            freq.put(x, f);
            if (f > maxfreq)
                maxfreq = f;

            group.computeIfAbsent(f, z-> new Stack()).push(x);
        }

        public int pop() {
            int x = group.get(maxfreq).pop();
            freq.put(x, freq.get(x) - 1);
            if (group.get(maxfreq).size() == 0)
                maxfreq--;
            return x;
        }
    }
}
