package design_patterns.solid;

/**
 * Liskov Substitution Principle
 * Objects of super class shall be replaced with object of subclasses.
 */
class Vehicle {
    public void start() {
        System.out.println("Starting a vechile.");
    }

    public void stop() {
        System.out.println("Stopping a vechile.");
    }
}

class Bike extends Vehicle {
    public void start() {
        System.out.println("Starting a bike.");
    }

    public void stop() {
        System.out.println("Stopping a bike.");
    }
}

class Car extends Vehicle {
    public void start() {
        System.out.println("Starting a car.");
    }

    public void stop() {
        System.out.println("Stopping a car.");
    }
}

public class LiskovSubstitutionPrinciple {
    static void testDrive(Vehicle vehicle) {
        vehicle.start();
        vehicle.stop();
    }

    public static void main(String[] args) {
        testDrive(new Vehicle());
        testDrive(new Bike());
        testDrive(new Car());
    }
}
