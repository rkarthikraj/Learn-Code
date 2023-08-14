package javaoops.concepts;

enum Size {
    SMALL, MEDIUM, LARGE, EXTRALARGE
}

class EnumTest {
    Size pizzaSize;

    public EnumTest(Size pizzaSize) {
        this.pizzaSize = pizzaSize;
    }

    public void orderPizza() {
        System.out.println(pizzaSize);

        switch (pizzaSize) {
            case SMALL:
                System.out.println("I ordered a small size pizza.");
                break;
            case MEDIUM:
                System.out.println("I ordered a medium size pizza.");
                break;
            default:
                System.out.println("I don't know which one to order.");
                break;
        }
    }
}


public class Enum {
    public static void main(String[] args) {
        System.out.println(Size.SMALL);
        System.out.println(Size.MEDIUM);

        EnumTest t1 = new EnumTest(Size.MEDIUM);
        t1.orderPizza();
    }
}
