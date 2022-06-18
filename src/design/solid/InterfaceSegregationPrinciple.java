package design.solid;

/**
 * Interface Segregation Principle
 * A client should never be forced to implement on interface that it does not use.
 */

interface VegRestaurant {
    void vegMeals();
}

interface NonVegRestaurant {
    void nonVegMeals();
}

class ParkVegRestaurant implements VegRestaurant {
    @Override
    public void vegMeals() {

    }
}

class ParkNonVegRestaurant implements NonVegRestaurant {
    @Override
    public void nonVegMeals() {

    }
}

public class InterfaceSegregationPrinciple {

}
