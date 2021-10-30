package s09;

import acm.program.ConsoleProgram;

/*
 * მომხმარებელს შეჰყავს ორი რიცხვი თქვენმა პროგრამამ უნდა დაბეჭდოს ამ ორი რიცხვის უმცირესი საერთო ჯერადი.
 */
public class Ex25 extends ConsoleProgram {

	@Override
	public void run() {
		// Input
		println("Program to find LCM(a, b)");
		int a = readInt("a=");
		int b = readInt("b=");

		// Evaluate
		int res = LCM(a, b);

		// Print
		println("LCM(" + a + ", " + b + ") = " + res);
	}

	private int LCM(int a, int b) {
		int lcm = Math.max(a, b);
		while (true) {
			if (lcm % a == 0 && lcm % b == 0)
				return lcm;
			lcm += Math.max(a, b);
		}
	}

}
