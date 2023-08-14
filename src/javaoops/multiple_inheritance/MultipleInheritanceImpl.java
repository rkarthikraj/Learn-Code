package javaoops.multiple_inheritance;

import javaoops.concepts.Interface;

public class MultipleInheritanceImpl implements InterfaceA, InterfaceB, InterfaceC {
    public void doSomethingInterfaceA(){
        System.out.println("Interface A method implemented in subclass");
    }

    public void doSomethingInterfaceB(){
        System.out.println("Interface B method implemented in subclass");
    }

    public void doSomethingInterfaceC(){
        System.out.println("Interface C method implemented in subclass");
    }
    public void doSomething(){}


    public static void main(String[] args) {
        InterfaceA objInterfaceA = new MultipleInheritanceImpl();
        InterfaceB objInterfaceB = new MultipleInheritanceImpl();
        InterfaceC objInterfaceC = new MultipleInheritanceImpl();

        objInterfaceA.doSomethingInterfaceA();
        objInterfaceB.doSomethingInterfaceB();

        objInterfaceC.doSomethingInterfaceC();
        objInterfaceC.doSomethingInterfaceA();
        objInterfaceC.doSomethingInterfaceB();
    }
}
