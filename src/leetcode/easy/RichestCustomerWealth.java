package leetcode.easy;

class RichestCustomerWealth {
    public static void main(String[] args) {
        RichestCustomerWealth obj = new RichestCustomerWealth();
        int[][] accounts = {{1, 2, 3}, {3, 2, 1}};
        System.out.println(obj.maximumWealth(accounts));
    }

    public int maximumWealth(int[][] accounts) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < accounts.length; i++) {
            int sum = 0;
            for (int j = 0; j < accounts[i].length; j++) {
                sum += accounts[i][j];
            }

            max = Math.max(sum, max);
        }
        return max;
    }
}