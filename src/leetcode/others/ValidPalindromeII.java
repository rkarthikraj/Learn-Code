package leetcode.others;

class ValidPalindromeII {
    public static void main(String[] args) {
        ValidPalindromeII obj = new ValidPalindromeII();
        //System.out.println(obj.validPalindrome("abc"));
        System.out.println(obj.validPalindrome("oxqxddgtnfhziinemrlrdwcwtjrwwitslafyvcakawvsavlxvlnqwyvhlxvoxfomzfkdjabkthpccssshgnfmfbbfxktrdonrzobsnokflcdcligmjclogadxqrahfnzzitqgkdmavtqpstggowikomvnwjyzdyxtuvwoggdhpbanlmtifuhidketdrabntjbflgspmevzkazcukgukloqcalbpcslrjsoqwwnslhsgmslzdadxbyqwbgzrixaerxyesswuyajaoeihdyvxeliowlreuxnkpgshvuphvrxsssbfzjyazqvbqhzoetrnbolvrpacccfkzoejkfgbilsgeidyfobdcxdafbdfgksqwevvngdjwwssxvdizdiuaqverdrpkbeouhkflqogpwachndkkipxjtcqdnsjcyvhyktoimiwtxapecwxfqasjiczsrauunwqkkplxfltqhxthniofkvlvvybwkisgzjqnvtpstdmyejzkgphdgnxrrjwtpjhqtsocudupmxzvyfygiglptzajydllofckvclneysnihunndglbbstjokbreqqfnlvntjglxghzdhxoyebwyejlsszxpwzmjsdreipfhsxxswmjjmafazmmxcnqsjdkcnecwyeomcqinulnbnzalsftdyfabqewlwfjlvhivqmisyocrrcsdgewmxyalakfnvxuydsbwxlorqkbidsgxnypolskguiktbvblbcmfecuvsoiasibnpecuhwbajiyysgogwglvzidqwvcbpeqdgphzcjxbypvzluvjmmsgnppgxyneoyelrtwcmswmutfmwalwwqqbvvehcseelsdktzobuxaryxliltpkbgzuzlqwrbzetedhlofrcgljvvfsbhbvkxwmvsjrsphfwktbzlhutfmqsqxtpiljygnslgzudksbvwloidcvbrtjtbyhbqijjmlnuqrtovuwdcwxtgdgbnikmoqxw"));
    }

    public boolean validPalindromeTLE(String s) {
        StringBuilder sb = new StringBuilder(s);
        if (s.equals(sb.reverse().toString())) {
            return true;
        }

        for (int i = 0; i < s.length(); i++) {
            StringBuilder temp = new StringBuilder(s);
            temp.replace(i, i + 1, "");
            String tempStr = temp.toString();
            //System.out.println(">> " + temp.toString());

            if (tempStr.equals(temp.reverse().toString())) {
                return true;
            }
        }
        return false;
    }

    public boolean validPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return (checkPalindrome(s, i, j - 1) || checkPalindrome(s, i + 1, j));
            }

            i++;
            j--;
        }
        return true;
    }

    private boolean checkPalindrome(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}