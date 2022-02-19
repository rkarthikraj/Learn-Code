package alogs.backtracking;

public class StringCombinations {
    public static void main(String[] args) {
        StringCombinations obj = new StringCombinations();
        String s = "ABC";
        obj.printPermutation(s, "");
    }

    public void printPermutation(String str, String permutation) {
        if (str.length() == 0) {
            System.out.println(permutation);
        }
        for (int i = 0; i < str.length(); i++) {
            char currentChar = str.charAt(i);
            String newStr = str.substring(0, i) + str.substring(i + 1);
            printPermutation(newStr, permutation + currentChar);
        }
    }
}
