package s09;

import acm.program.ConsoleProgram;

/*
 * მომხმარებელს შეყავს n და m დაბეჭდეთ n^m
 */
public class Ex27 extends ConsoleProgram {

	@Override
	public void run() {
		// Input
		println("Program to find n^m");
		int n = readInt("n=");
		int m = readInt("m=");

		// Evaluate
		int res = pow(n, m);

		// Print
		println(n + "^" + m + " = " + res);
	}

	// n^m = n*n*n*n*...*n*n
	private int pow(int n, int m) {
		int res = 1;
		for (int i = 0; i < m; i++) {
			res *= n;
		}
		return res;
	}

}