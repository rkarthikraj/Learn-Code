package leetcode.biweekly.contest69;

class CapitalizeTitle {
    public static void main(String[] args) {
        CapitalizeTitle obj = new CapitalizeTitle();
        String title1 = "capiTalIze tHe titLe";
        String title2 = "First leTTeR of EACH Word";
        String title3 = "i lOve leetcode";

        System.out.println(obj.capitalizeTitle(title1));
        System.out.println(obj.capitalizeTitle(title2));
        System.out.println(obj.capitalizeTitle(title3));
    }

    public String capitalizeTitle(String title) {
        StringBuilder sb = new StringBuilder();
        String[] titleArr = title.toLowerCase().split(" ");
        for (String s : titleArr) {
            if (s.length() > 2) {
                sb.append(s.toUpperCase().charAt(0) + s.substring(1, s.length()) + " ");
            } else {
                sb.append(s + " ");
            }
        }
        return sb.toString().trim();
    }
}