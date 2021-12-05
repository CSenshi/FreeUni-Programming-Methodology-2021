package s18;

import acm.program.ConsoleProgram;

/*
 * დაწერეთ stringToInteger მეთოდი, რომელსაც გადაეცემა სტრინგი და აბრუნებს მთელ რიცხვს.
 * 
 * ჩათვალეთ, რომ გადაცემული სტრინგი მხოლოდ ციფრებისგან შედგება და არ იწყება 0-ით.
 * ასევე ჩათვალეთ, რომ დაბრუნებული მნიშვნელობა დადებითია და ეტევა int-ში.
 * 
 * მაგალითად: “234” გადაცემის შემთხვევაში მეთოდმა უნდა დააბრუნოს 234. 
 */
public class Ex49 extends ConsoleProgram {

	public void run() {
		// Input
		String numStr = readLine("Input: ");

		// Evaluate
		int res = stringToInt(numStr);

		// Print Result
		println(res);
	}

	// Implementation with only positive integers
	private int stringToInt(String numStr) {
		if (numStr.charAt(0) == '-') {
			return -stringToInt(numStr.substring(1));
		}

		int res = 0;

		for (int i = 0; i < numStr.length(); i++) {
			char curChar = numStr.charAt(i);
			int curInt = curChar - '0';

			res *= 10;
			res += curInt;
		}

		return res;
	}
}