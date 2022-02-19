package leetcode.biweekly.contest70;

import java.util.ArrayList;
import java.util.List;

class MaximumSplitOfPositiveEvenIntegers {
    public static void main(String[] args) {
        MaximumSplitOfPositiveEvenIntegers obj = new MaximumSplitOfPositiveEvenIntegers();
        long finalSum1 = 12;
        long finalSum2 = 7;
        long finalSum3 = 8;
        //System.out.println(obj.maximumEvenSplit(finalSum1));
        //System.out.println(obj.maximumEvenSplit(finalSum2));
        System.out.println(obj.maximumEvenSplit(finalSum3));
    }

    public List<Long> maximumEvenSplit(long finalSum) {
        List<Long> result = new ArrayList<>();

        for (long i = 1; i <= finalSum; i++) {
            List<Long> tempResult = new ArrayList<>();
            long sum = 0;
            for (long j = i; j < finalSum; j++) {
                if (j % 2 == 0) {
                    sum += j;
                    tempResult.add(j);
                    if(sum == finalSum) {
                        if(result.size() < tempResult.size()) {
                            result = tempResult;
                            break;
                        }
                    } else if(sum > finalSum) {
                        break;
                    }
                }
            }
        }

        return result;
    }
}