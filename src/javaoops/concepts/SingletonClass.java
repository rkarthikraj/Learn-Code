package javaoops.concepts;

import java.io.IOException;

class Singleton {
    static Singleton objSingleton = null;

    private Singleton() {

    }

    public static Singleton getInstance() {
        if (objSingleton == null) {
            objSingleton = new Singleton();
        }
        return objSingleton;
    }
}

public class SingletonClass {
    public static void main(String[] args) throws IOException {
        Singleton s1 = Singleton.getInstance();
        System.out.println(s1);

        Singleton s2 = Singleton.getInstance();
        System.out.println(s2);
    }
}
