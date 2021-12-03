package javaoops.inheritance;

/*
Multilevel inheritance is a process of deriving a class from another derived class.
 */
class MultilevelInheritanceShape {
    public void display() {
        System.out.println("Inside display");
    }
}

class Rectangle extends MultilevelInheritanceShape {
    public void area() {
        System.out.println("Inside area");
    }
}

class Cube extends Rectangle {
    public void volume() {
        System.out.println("Inside volume");
    }
}

public class MultilevelInheritance {
    public static void main(String[] args) {
        Cube cube = new Cube();
        cube.display();
        cube.area();
        cube.volume();
    }
}
