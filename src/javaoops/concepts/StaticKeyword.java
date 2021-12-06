package javaoops.concepts;

public class StaticKeyword {

    static String companyName = "Mastech Infotrellis";
    String name = "KarthikRaj";

    // Static method
    static void myStaticMethod() {
        System.out.println("Static methods can be called without creating objects");
    }

	// Public method
    public void myPublicMethod() {
        System.out.println("Public methods must be called by creating objects");
    }

	// Main method
	public static void main(String[] args) {
		myStaticMethod(); // Call the static method
		// myPublicMethod(); This would output an error

		StaticKeyword obj = new StaticKeyword(); // Create an object of Main
		obj.myPublicMethod(); // Call the public method

		System.out.println("Result Static -> " + companyName);
		System.out.println("Result -> " + obj.name);
	}

}
