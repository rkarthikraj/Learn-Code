package leetcode.msiq;

import java.util.ArrayList;
import java.util.List;

class RemoveComments {
    public static void main(String[] args) {
        RemoveComments obj = new RemoveComments();
        // String[] source = {"/*Test program */", "int main()", "{ ", "  // variable declaration ", "int a, b, c;", "/* This is a test", "   multiline  ", "   comment for ", "   testing */", "a = b + c;", "}"};
        String[] source = {"a/*comment", "line", "more_comment*/b"};
        System.out.println(obj.removeComments(source));
    }

    public List<String> removeComments(String[] source) {
        List<String> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        boolean isBlockCommentFound = false;

        for (String line : source) {

            int i = 0;
            int length = line.length();
            while (i < length) {
                if (!isBlockCommentFound) {
                    if ((i + 1) < length && line.charAt(i) == '/' && line.charAt(i + 1) == '/') {
                        break;
                    } else if ((i + 1) < length && line.charAt(i) == '/' && line.charAt(i + 1) == '*') {
                        isBlockCommentFound = true;
                        i += 2;
                    } else {
                        sb.append(line.charAt(i));
                        i++;
                    }
                } else {
                    if ((i + 1) < length && line.charAt(i) == '*' && line.charAt(i + 1) == '/') {
                        isBlockCommentFound = false;
                        i += 2;
                    } else {
                        i++;
                    }
                }
            }

            if (!isBlockCommentFound) {
                addToList(sb, result);
                sb.setLength(0);
            }
        }
        return result;
    }

    public void addToList(StringBuilder sb, List<String> result) {
        if (sb.toString().length() != 0) {
            result.add(sb.toString());
        }
    }
}

