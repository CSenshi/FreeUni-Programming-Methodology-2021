package exams.m2020;

import java.util.HashMap;
import java.util.Map;

import acm.program.*;

public class M2020Ex02 extends ConsoleProgram {

	@Override
	public void run() {
		// int n = balance("LRLR") // <-- usage
		runTests(); // run tests
	}

	private void runTests() {
		Map<String, Integer> tests = new HashMap<String, Integer>() {
			{
				put("LLRR", 1);
				put("LRLR", 2);
				put("LLRRLRRL", 3);
				put("LRLRLRLRRLRLRLRL", 8);
				put("RLLR", 2);
			}
		};

		int maxStr = 0;
		for (Map.Entry<String, Integer> entry : tests.entrySet()) {
			maxStr = Math.max(entry.getKey().length(), maxStr);
		}

		int count = 0;
		int testNum = 1;
		for (Map.Entry<String, Integer> entry : tests.entrySet()) {
			String input = entry.getKey();
			int expectedResult = entry.getValue();
			testNum++;
			int result = balance(input);

			String intAsStr = "" + input;
			String delim = "";
			for (int j = 0; j < maxStr + 1 - intAsStr.length(); j++) {
				delim += ' ';
			}

			print("Test " + testNum + ": reverse(" + input + ")" + delim + "Expected=" + expectedResult);
			intAsStr = "" + expectedResult;
			delim = "";
			for (int j = 0; j < 4 - intAsStr.length(); j++) {
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
		println("Tests passed: " + count + "/" + tests.size());
	}

	private int balance(String input) {
		int L = 0, R = 0, count = 0;
		for (int i = 0; i < input.length(); i++) {
			if (input.charAt(i) == 'L') {
				L++;
			} else {
				R++;
			}
			if (L == R) {
				count++;
			}
		}
		return count;
	}
}
