package javaoops.inheritance;

class SingleLevelInheritanceShape {
    double half = 1d / 2;

    public void area(String shapeName) {
        System.out.println("Displays the area of " + shapeName);
    }
}

class Triangle extends SingleLevelInheritanceShape {
    public void area(int h, int b) {
        double a = half * (b * h);
        System.out.println(a);
    }
}

public class SingleLevelInheritance {
    public static void main(String[] args) {
        Triangle obj = new Triangle();
        obj.area(obj.getClass().getSimpleName());
        obj.area(20, 10);
    }
}
