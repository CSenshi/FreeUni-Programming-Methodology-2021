package s09;

import acm.program.ConsoleProgram;

/*
 * მომხმარებელს შეყავს დადებითი რიცხვები, მანამ სანამ არ შეიყვანს -1 ს.
 * 
 * დაბეჭდეთ რაოდენობა რამდენი ლუწი რიცხვი შეყვანა მომხმარებელმა.
 */
public class Ex28 extends ConsoleProgram {

	private final int SENTINEL = -1;

	@Override
	public void run() {
		int totalEvenNum = 0;
		while (true) {
			// Read Input
			int n = readInt();

			// Check if input is SENTINEL (default -1)
			if (n == SENTINEL) {
				break;
			}

			// Check if number is even, increase count if even
			if (n % 2 == 0) {
				totalEvenNum++;
			}
		}

		println("Total Even Numbers Entered: " + totalEvenNum);
	}
}