package javaoops.concepts.copy_constructor;

public class Student {
    private int rollNumber;
    private int age;
    private String name;

    // default constructor
    public Student(int rollNumber, int age, String name) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.age = age;
    }

    public Student(Student student) {
        this.rollNumber = student.rollNumber;
        this.name = student.name;
        this.age = student.age;
    }

    public void displayStudent() {
        System.out.println("Rollnumber : " + this.rollNumber);
        System.out.println("Name : " + this.name);
        System.out.println("Age : " + this.age);
    }

    public static void main(String[] args) {
        Student objStudent = new Student(1001, 20, "TOM");
        objStudent.displayStudent();

        System.out.println("Constructor Overloading - Copied object is passed to Student class constructor");
        Student copyStudent = new Student(objStudent);
        copyStudent.displayStudent();
    }
}
