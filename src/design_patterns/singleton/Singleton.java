package design_patterns.singleton;

/* Eager Loading
 * Not thread safe since instance is already get initialized
 */
/*public class Singleton {
    private static Singleton objSingleton = new Singleton();
    private Singleton() {}
    public static Singleton getInstance() {
        return objSingleton;
    }
}*/

/* Lazy Loading
 * Here instance is initialized only if it is not initialized.
 * Because we dont have to initialize it from the starting itself
 */
/*public class Singleton {
    private static Singleton objSingleton = null;

    private Singleton() {
    }

    public static Singleton getInstance() {
        if (objSingleton == null) {
            objSingleton = new Singleton();
        }
        return objSingleton;
    }
}*/

/* Thread Safety
 * It is really important in case of singleton implementation.
 * volatile - is a keyword in java which makes the changes or threads which are accessing this particular variable visible.
 * Synchronize will ensure that no two threads are initializing the instance at the same time because they will be blocked and they will be wait for each other to unblock to get their turn
 */
public class Singleton {
    private static volatile Singleton objSingleton = null;

    private Singleton() {
        if (objSingleton != null) {
            throw new RuntimeException("Instance already initialized");
        }
    }

    public static Singleton getInstance() {
        if (objSingleton == null) {
            synchronized (Singleton.class) {
                if (objSingleton == null) {
                    objSingleton = new Singleton();
                }
            }
        }
        return objSingleton;
    }
}