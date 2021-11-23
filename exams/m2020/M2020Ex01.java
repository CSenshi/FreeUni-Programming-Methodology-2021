package exams.m2020;

import acm.program.*;

public class M2020Ex01 extends ConsoleProgram {

	@Override
	public void run() {
		// int n = reverse(7) // <-- usage
		runTests(); // run tests
	}

	private void runTests() {
		int[][] tests = new int[][] {
				{ 7, 2147483640 },
				{ 2147483640, 7 }, 
				{ 1000, 2147482647 }, 
				{ 2147482647, 1000 },
				{ 12379641, 2135104006 }, 
				{ 2135104006, 12379641 }, 
				{ 0, 2147483647 }, 
				{ 2147483647, 0 },
			};
		int count = 0;
		for (int i = 0; i < tests.length; i++) {
			int input = tests[i][0];
			int expectedResult = tests[i][1];
			int result = reverse1(input); // <- Change this to custom function

			String intAsStr = "" + input;
			String delim = "";
			for (int j = 0; j < 12 - intAsStr.length(); j++) {
				delim += ' ';
			}

			print("Test " + i + ": reverse(" + input + ")" + delim + "Expected=" + expectedResult);
			intAsStr = "" + expectedResult;
			delim = "";
			for (int j = 0; j < 12 - intAsStr.length(); j++) {
				delim += ' ';
			}
			print(delim + "... ");
			if (result == expectedResult) {
				count++;
				println("Passed!");
			} else {
				println("Failed! Got: " + result);
			}

		}
		println("Tests passed: " + count + "/" + tests.length);
	}

	/** SOLUTION 1 **/
	private int reverse1(int input) {
		return Integer.MAX_VALUE - input;
	}

	/** SOLUTION 2 **/
	private int reverse2(int input) {
		String intAsBin = intToBinary(input);
		String reversedString = reverseString(intAsBin);
		int result = binaryToInt(reversedString);
		return result;
	}

	private String intToBinary(int input) {
		String result = "";

		// convert int to binary
		while (input != 0) {
			if (input % 2 == 0) {
				result = '0' + result;
			} else {
				result = '1' + result;
			}
			input = input / 2;
		}

		// left pad with zeros
		while (result.length() != 31) {
			result = '0' + result;
		}

		return result;
	}

	private String reverseString(String inputAsString) {
		String result = "";
		for (int i = 0; i < inputAsString.length(); i++) {
			if (inputAsString.charAt(i) == '0') {
				result += '1';
			} else {
				result += '0';
			}
		}
		return result;
	}

	private int binaryToInt(String s) {
		int result = 0;
		for (int i = 0; i < s.length(); i++) {
			result *= 2;
			if (s.charAt(i) == '1') {
				result += 1;
			}
		}
		return result;

	}

}
