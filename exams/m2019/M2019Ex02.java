package exams.m2019;

import acm.program.ConsoleProgram;

/*-
 * თქვენი ამოცანაა გაარკვიოთ არის თუ არა რიცხვი პალინდრომი.
 * 
 * რიცხვი პალინდრომია მაშინ და მხოლოდ მაშინ თუკი ის როგორც მარჯვნიდან მარცხნივ ისე მარცხნიდან მარჯვნივ ერთნაირად იკითხება. 
 * 
 * მაგალითად, პალინდრომებია 121, 44, 7, 13231, 6472746 და ა.შ.
 * 
 * დაწერეთ isPalindrom მეთოდი რომელსაც გადაეცემა მთელი რიცხვი და რომელიც აბრუნებს true-ს თუკი ეს რიცხვი პალინდრომია, 
 * ხოლო false-ს თუკი ეს რიცხვი პალინდრომი არ არის.
 * 
 * ამოხსნისას არ გამოიყენოთ სტრინგები, ასევე ლექციებზე ჯერ არ გარჩეული მონაცემთა სტრუქტურები(მასივები, არაილისტები და ა.შ.). 
 */
public class M2019Ex02 extends ConsoleProgram {

	public void run() {
		// boolean result = isPalindrom(12321); // should return true
		runTests();
	}

	private void runTests() {
		// All Should Be True
		println("Test Palindromes");
		int trueArr[] = { 121, 44, 7, 13231, 6472746 };
		for (int i = 0; i < trueArr.length; i++) {
			boolean result = isPalindrom(trueArr[i]);
			if (result) {
				println("PASS: " + trueArr[i] + " -> " + result);
			} else {
				println("FAIL: " + trueArr[i] + " -> " + result);
			}
		}

		// All Should Be False
		println("\nTest No Palindromes");
		int falseArr[] = { 10, 1000, 654, 13, 1354328 };
		for (int i = 0; i < falseArr.length; i++) {
			boolean result = isPalindrom(falseArr[i]);
			if (!result) {
				println("PASS: " + falseArr[i] + " -> " + result);
			} else {
				println("FAIL: " + falseArr[i] + " -> " + result);
			}
		}
	}

	/** Solution **/
	private boolean isPalindrom(int x) {
		int reversed = reverse(x);
		return reversed == x;
	}

	private int reverse(int x) {
		int res = 0;
		while (x != 0) {
			res = res * 10 + x % 10;
			x /= 10;
		}
		return res;
	}
}
