package alogs.search;

class BinarySearchDuplcateValues {
    public static void main(String[] args) {

        int[] numbers = {1, 2, 3, 3, 3, 4, 5, 6, 7};
        int target = 3;

        int low = 0, high = numbers.length - 1;
        // get the start index of target number
        int startIndex = -1;
        while (low <= high) {
            int mid = (high - low) / 2 + low;
            if (numbers[mid] > target) {
                high = mid - 1;
            } else if (numbers[mid] == target) {
                startIndex = mid;
                high = mid - 1;
            } else
                low = mid + 1;
        }


        // get the end index of target number
        int endIndex = -1;
        low = 0;
        high = numbers.length - 1;
        while (low <= high) {
            int mid = (high - low) / 2 + low;
            if (numbers[mid] > target) {
                high = mid - 1;
            } else if (numbers[mid] == target) {
                endIndex = mid;
                low = mid + 1;
            } else
                low = mid + 1;
        }

        System.out.println("StartIndex: " + startIndex + ", EndIndex: " + endIndex);
        while (startIndex <= endIndex) {
            System.out.println(startIndex);
            startIndex++;
        }


        //        if (startIndex != -1 && endIndex != -1) {
        //            for (int i = 0; i + startIndex <= endIndex; i++) {
        //                if (i > 0)
        //                    System.out.print(',');
        //                System.out.print(i + startIndex);
        //            }
        //        }
    }
}