package javaoops.multiple_inheritance_diamond_problem;

public class MultipleInheritance {
    public static void main(String[] args) {
        ClassA objClassA = new ClassA();
        ClassB objClassB = new ClassB();

        objClassA.doSomething();
        objClassB.doSomething();
    }
}
