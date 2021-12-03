package bigo;

import java.io.IOException;

public class RecursiveCall {
	public static int pairSumSequence(int n) {
		int sum = 0;
		for (int i = 0; i < n; i++) {
			sum += pairSum(i, i + 1);
			System.out.println("---------");
			System.out.println(sum);
			System.out.println("---------");
		}

		return sum;
	}

	public static int pairSum(int a, int b) {
		System.out.println("i -> " + a + ", i + 1 -> " + b);
		return a + b;
	}

	public static void main(String[] args) throws IOException {
		System.out.println(pairSumSequence(5));
	}
}
