package design.singleton;

public class SingletonInstance {
    public static void main(String[] args) {
        Singleton initialSingletonInstance = Singleton.getInstance();
        System.out.println("Initial Singleton Instance: " + initialSingletonInstance.hashCode());

        Singleton secondSingletonInstance = Singleton.getInstance();
        System.out.println("Second Singleton Instance: " + secondSingletonInstance.hashCode());
    }
}
