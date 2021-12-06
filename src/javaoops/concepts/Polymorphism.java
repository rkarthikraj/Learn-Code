package javaoops.concepts;

import java.io.IOException;

public class Polymorphism {
	public static void main(String[] args) throws IOException{
		Polymorphism objPolyTest = new Polymorphism();
		objPolyTest.display(1,2);
		objPolyTest.display("KarthikRaj", "MastechInfotrellis");
	}

	void display(String name, String companyName) {
		System.out.println(name + ":" + companyName);
	}

	void display(int value1, int value2) {
		System.out.println(value1 + value2);
	}

}
