package javaoops.concepts;

import java.io.IOException;

abstract class TestAbstract {
    abstract void testAbstractMethod();

    void nonAbstractMethod() {
        System.out.println("This is an Non Abstract Method in an Abstract Class");
    }
}

class Test1 extends TestAbstract {
    void nonAbstractMethod() {
        super.nonAbstractMethod();
    }

    void testAbstractMethod() {
        System.out.println("TEST 1");
    }
}

class Test2 extends TestAbstract {
    void testAbstractMethod() {
        System.out.println("TEST 2");
    }
}

class Test3 extends TestAbstract {
    @Override
    void testAbstractMethod() {
        System.out.println("TEST 3");
    }
}


public class Abstract {
    public static void main(String[] args) throws IOException {
        Test1 objTest1 = new Test1();
        Test2 objTest2 = new Test2();
        objTest1.nonAbstractMethod();
        objTest1.testAbstractMethod();
        objTest2.testAbstractMethod();

    }
}