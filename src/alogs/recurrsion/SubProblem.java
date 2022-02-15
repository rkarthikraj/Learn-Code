package alogs.recurrsion;

public class SubProblem {
    public static void main(String[] args) {
        SubProblem obj = new SubProblem();
        obj.recursiveExample(5);
    }

    public void recursiveExample(int value) {
        if (value == 10) {
            return;
        }
        recursiveExample(1 + value);
        System.out.println(value);
    }
}
