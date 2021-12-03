package javaoops.inheritance;

/*
Class B and C extends class A → Hierarchical inheritance
Class D extends class A → Single inheritance
The below code can be used to understand the working.
 */

class A {
    public void displayFromA() {
        System.out.println("The program control is in class A");
    }
}

// Hierarchical Inheritance
class B extends A {
    public void displayFromB() {
        System.out.println("The program control is in class B");
    }
}

// Hierarchical Inheritance
class C extends A {
    public void displayFromC() {
        System.out.println("The program control is in class C");
    }
}

//Single Inheritance
class D extends A {
    public void displayFromD() {
        System.out.println("The program control is in class D and It is an example to demonstrate the working of hybrid inheritance in Java.");
    }
}

class HybridInheritance {
    public static void main(String args[]) {
        B objB = new B();
        C objC = new C();

        objB.displayFromA();
        objB.displayFromB();

        objC.displayFromA();
        objC.displayFromC();

        D objD = new D();
        objD.displayFromD();
    }

}