package a1;

public interface Foo {
    public default String HelloWorld() {
        return "Hello World";
    }

    String method(String string, String string2);
}