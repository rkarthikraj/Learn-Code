package alogs.recurrsion;

public class StringReversal {
    public static void main(String[] args) {
        StringReversal obj = new StringReversal();
        String input = "Recurrsion is simple to learn";
        String[] inputArr = input.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = inputArr.length - 1; i >= 0; --i) {
            sb.append(obj.reverseString(inputArr[i]) + " ");
        }

        System.out.println(sb.toString());
    }

    public String reverseString(String input) {
        if (input.equals("")) {
            return "";
        }
        return reverseString(input.substring(1)) + input.charAt(0);
    }
}
