package javaoops.inheritance;

/*
Hierarchical inheritance is  defined as the process of deriving more than class from a base class.
 */
class Employee {
    float salary = 40000;

    void displaySalary() {
        System.out.println("The employee salary is :" + salary);
    }
}

class PermanentEmployee extends Employee {
    double hike = 0.5;

    void incrementSalary() {
        System.out.println("The permanent employee incremented salary is :" + (salary + (salary * hike)));
    }
}

class TemporaryEmployee extends Employee {
    double hike = 0.35;

    void incrementSalary() {
        System.out.println("The temporary employee incremented salary is :" + (salary + (salary * hike)));
    }
}

public class HierarchicalInheritance {
    public static void main(String[] args) {
        PermanentEmployee objP = new PermanentEmployee();
        TemporaryEmployee objT = new TemporaryEmployee();

        objP.displaySalary();
        objP.incrementSalary();
        objT.displaySalary();
        objT.incrementSalary();
    }
}
