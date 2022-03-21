package a1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FunctionalInterface {
    public static void main(String[] args) {
        FunctionalInterface obj = new FunctionalInterface();

        Foo foo = (a, b) -> a + " from lambda " + b;
        String result = obj.add("Message", foo);
        System.out.println(result);
        System.out.println(foo.HelloWorld());

        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);

        //        list.stream().forEach(a -> list.add(a + 1));
        //        int size = list.size();
        //        for (int i = 0; i < size; i++) {
        //            list.add(list.get(i) + 1);
        //        }
        System.out.println("---");
        list.stream().filter(a -> a > 3).forEach(a -> System.out.println(a));

        List<String> lines = Arrays.asList("spring", "node", "mkyong");

        List<String> result1 = lines.stream().filter(line -> !line.equals("mkyong")).collect(Collectors.toList());

        result1.forEach(System.out::println);                //output : spring, node

    }

    public String add(String string, Foo foo) {
        return foo.method(string, "Test");
    }


}
