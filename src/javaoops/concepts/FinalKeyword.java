package javaoops.concepts;

public class FinalKeyword {
	final int x = 10;
	public static void main(String[] args) {
		FinalKeyword obj = new FinalKeyword();
		//objFinalKeywordDemo.x = 25; // will generate an error: cannot assign a value to a final variable
		System.out.println(obj.x);
	}
}
