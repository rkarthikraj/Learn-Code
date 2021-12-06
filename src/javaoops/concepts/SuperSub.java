package javaoops.concepts;

class Super {
    String s;

    public Super(){
        System.out.println("Super");
    }
}

public class SuperSub extends Super {

    public SuperSub(){
        System.out.println("Sub");
    }

    public static void main(String[] args){
        SuperSub s = new SuperSub();
    }
}