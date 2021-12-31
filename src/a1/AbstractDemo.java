package a1;

class IPhone extends Phone {
    public void showConfig() {
        System.out.println("IPhone13 PRO, 8GB RAM, 256GB STORAGE, Monolithic Blue");
    }
}

class Samsung extends Phone {
    public void showConfig() {
        System.out.println("S20, 32GB RAM, 256GB STORAGE, MIDNIGHT BLUE");
    }
}

abstract class Phone {
    public abstract void showConfig();
}

public class AbstractDemo {
    public static void main(String[] args) {
        IPhone objIPhone = new IPhone();
        Samsung objSamsung = new Samsung();

        show(objIPhone);
        show(objSamsung);
    }

    public static void show(Phone obj) {
        obj.showConfig();
    }
}
