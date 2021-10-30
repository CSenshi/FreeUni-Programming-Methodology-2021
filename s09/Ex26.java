package s09;

import acm.program.ConsoleProgram;

/*
 * მომხმარებელს შეჰყავს ორი რიცხვი თქვენმა პროგრამამ უნდა დაბეჭდოს ამ ორი რიცხვის უდიდესი საერთო გამყოფი.
 */
public class Ex26 extends ConsoleProgram {

	@Override
	public void run() {
		// Input
		println("Program to find GCD(a, b)");
		int a = readInt("a=");
		int b = readInt("b=");

		// Evaluate
		int gcd = GCD(a, b);

		// Print
		println("GCD(" + a + ", " + b + ") = " + gcd);
	}

	private int GCD(int a, int b) {
		for (int i = Math.min(a, b); i >= 1; i--) {
			if (a % i == 0 && b % i == 0) {
				return i;
			}
		}
		return 0;
	}
}