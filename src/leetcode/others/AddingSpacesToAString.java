package leetcode.others;

class AddingSpacesToAString {
    public static void main(String[] args) {
        AddingSpacesToAString obj = new AddingSpacesToAString();
        String s = "spacing";
        int[] spaces = {0,1,2,3,4,5,6};
        System.out.println(obj.addSpaces(s, spaces));
    }

    public String addSpaces(String s, int[] spaces) {
        StringBuilder sb = new StringBuilder();

        int counter = 0;
        for (int i : spaces) {
            System.out.println(i);
            while (counter <= i - 1) {
                sb.append(s.charAt(counter));
                counter++;
            }
            sb.append(" ");
        }

        while (counter < s.length()) {
            sb.append(s.charAt(counter++));
        }

        return sb.toString();
    }
}