package javaoops.concepts;

public class GenericClass<T1, T2> {
    public void display(T1 var1, T2 var2) {
        System.out.println("Var1 >> " + var1 + "  Var2 >> " + var2);
    }

    public static void main(String[] args) {
        GenericClass<String, Integer> objGenericClass1 = new GenericClass<String, Integer>();
        GenericClass<Integer, Integer> objGenericClass2 = new GenericClass<Integer, Integer>();

        objGenericClass1.display("Karthik Raj", 25);
        objGenericClass2.display(1, 2);

        int a = 5;
        int b = 4;
        int c = 5;
        int d = 6;

        int z,y,x,w;

        w = a++;
        x = ++b;
        y = c--;
        z = --d;

        System.out.println("a++ >> " + w);
        System.out.println("++b >> " + x);
        System.out.println("c-- >> " + y);
        System.out.println("--d >> " + z);
    }
}
