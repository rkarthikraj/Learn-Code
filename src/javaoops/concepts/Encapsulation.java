package javaoops.concepts;

class EmployeeDetails {
    private String name;
    private String teamName;
    private int age;
    private double yearsOfExperience;
    private String email;


    public void setName(String name) {
        this.name = name;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setYearsOfExperience(double yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getTeamName() {
        return teamName;
    }

    public int getAge() {
        return age;
    }

    public double getYearsOfExperience() {
        return yearsOfExperience;
    }

    public String getEmail() {
        return email;
    }
}

public class Encapsulation {
    public static void main(String[] args) {
        EmployeeDetails objEmployeeDetails = new EmployeeDetails();
        objEmployeeDetails.setName("KarthikRaj");
        objEmployeeDetails.setTeamName("Data Engineering");
        objEmployeeDetails.setAge(29);
        objEmployeeDetails.setYearsOfExperience(6.5);
        objEmployeeDetails.setEmail("rkarthykraj@gmail.com");

        System.out.println("Name: " + objEmployeeDetails.getName());
        System.out.println("Team Name: " + objEmployeeDetails.getTeamName());
        System.out.println("Age: " + objEmployeeDetails.getAge());
        System.out.println("Years of Experience: " + objEmployeeDetails.getYearsOfExperience());
        System.out.println("Email: " + objEmployeeDetails.getEmail());
    }
}
