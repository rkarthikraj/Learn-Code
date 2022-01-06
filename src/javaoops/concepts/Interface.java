package javaoops.concepts;

import java.io.IOException;

interface TestA {
    void show();
}

interface TestB {
    void show();
}

interface TestC extends TestA, TestB {

}

abstract class TestAB {
    abstract void show();
}

class Demo extends TestAB implements TestA, TestB {
    @Override
    public void show() {
        System.out.println("Interface implemented");
    }
}

public class Interface {
    public static void main(String[] args) throws IOException {
        Demo obj = new Demo();
        obj.show();
    }
}
