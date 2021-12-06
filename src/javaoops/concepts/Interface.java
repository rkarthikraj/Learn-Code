package javaoops.concepts;

import java.io.IOException;

interface Test {
    void run();

    void stop();

    void start();

    void walk();
}

interface Extra extends Test{
    void isWorking();
}
class Demo implements Test {
    public void stop() {

    }

    public void run() {

    }

    public void start() {

    }

    public void walk() {

    }

    public void myMethod() {

    }
}

public class Interface {
    public static void main(String[] args) throws IOException {
        Test objTest = new Demo();
        ((Demo) objTest).myMethod();
    }
}
