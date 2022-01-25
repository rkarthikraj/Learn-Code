package leetcode.biweekly.contest70;

class CountHiddenSequences {
    public static void main(String[] args) {
        CountHiddenSequences obj = new CountHiddenSequences();

        int[] differences1 = {1, -3, 4};
        int lower1 = 1, upper1 = 6;
        System.out.println(obj.numberOfArrays(differences1, lower1, upper1));

        // int[] differences2 = {3, -4, 5, 1, -2};
        // int lower2 = -4, upper2 = 5;
        // System.out.println(obj.numberOfArrays(differences2, lower2, upper2));
    }

    public int numberOfArrays(int[] differences, int lower, int upper) {
        long min = 0;
        long max = 0;

        long sum = 0;

        for (int value : differences) {
            sum += value;
            min = Math.min(sum, min);
            max = Math.max(sum, max);
        }

        long start = lower - min;
        long end = upper - max;

        if(start > end) {
            return 0;
        }

        return (int) (end - start + 1);
    }

    //    public int numberOfArrays(int[] differences, int lower, int upper) {
    //        int result = 0;
    //        int diffLength = differences.length;
    //        List<Integer> list = new ArrayList<>();
    //
    //        Map<Integer, Integer> limits = new HashMap<>();
    //        for (int i = lower; i <= upper; i++) {
    //            limits.put(i, i);
    //        }
    //
    //        for (int i = diffLength - 1; i >= 0; --i) {
    //            int value = differences[i];
    //            while (upper >= lower) {
    //                int hiddenValue1 = 0;
    //                Integer listLastValue = null;
    //                if (list.size() > 0) {
    //                    listLastValue = list.get(list.size() - 1);
    //                }
    //                if (listLastValue != null) {
    //                    hiddenValue1 = listLastValue;
    //                } else {
    //                    hiddenValue1 = limits.get(upper);
    //                }
    //
    //                System.out.println("hiddenValue1 -> " + hiddenValue1 + ", value: " + value);
    //                if (limits.containsKey(hiddenValue1 - value)) {
    //                    int hiddenValue2 = limits.get(hiddenValue1 - value);
    //                    if (!list.contains(hiddenValue1)) {
    //                        list.add(hiddenValue1);
    //                    }
    //                    list.add(hiddenValue2);
    //                    break;
    //                }
    //                upper--;
    //            }
    //
    //            if (list.size() == (diffLength + 1)) {
    //                result++;
    //                break;
    //            }
    //        }
    //
    //        System.out.println(list);
    //        return result;
    //    }

}