package alogs.recurrsion;

public class CallStack {
    public static void main(String[] args) {
        CallStack obj = new CallStack();
        obj.callStack();
    }

    public String callStack() {
        return callStack();
    }
}
