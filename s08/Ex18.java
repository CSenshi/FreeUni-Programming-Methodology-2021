package s08;

import acm.program.ConsoleProgram;

/*
 * კონსოლიდან წაიკითხეთ ორი მთელი რიცხვი და დაბეჭდეთ მათ შორის მაქსიმალური.
 */
public class Ex18 extends ConsoleProgram {

	@Override
	public void run() {
		// Read Input
		int input1 = readInt();
		int input2 = readInt();

		// Evaluate
		int maxNumber = max(input1, input2);

		// Print result
		println("maxNumber = " + maxNumber);
	}

	private int max(int input1, int input2) {
		if (input1 > input2) {
			return input1;
		}
		return input2;
	}
}
