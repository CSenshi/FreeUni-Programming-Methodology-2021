package exams.m2021.s2;

import acm.program.*;

/*-
 * თქვენი ამოცანაა დაადგინოთ, არის თუ არა მომხმარებლის მიერ შემოყვანილი რიცხვები არითმეტიკული პროგრესია.
 * 
 * ჩათვალეთ, რომ მომხმარებელს მხოლოდ მთელი რიცხვები შემოყავს, მანამ სანამ არ შემოიყვანს -1-ს
 * 
 * როგორც კი მომხმარებელი -1-ს შემოიყვანს თქვენმა პროგრამამ უნდა დაბეჭდოს სტრინგი:
 * - "Arithmetic progression" - თუ შემოყვანილი რიცხვები არითმეტიკული პროგრესიაა
 * - "Not an arithmetic progression" - თუ შემოყვანილი რიცხვები არითმეტიკული პროგრესია არაა
 */
public class M2021S2Ex01 extends ConsoleProgram {

	private final static int SENTINEL = -1;

	@Override
	public void run() {
		// Read Number 1
		int last = readInt("Please input number: ");
		if (last == SENTINEL) {
			println("Arithmetic progression!");
			return;
		}

		// Read Number 2
		int curr = readInt("Please input number: ");
		if (curr == SENTINEL) {
			println("Arithmetic progression!");
			return;
		}

		// Calculate diff
		int diff = curr - last;
		last = curr;

		// Iterate over and over
		while (true) {
			curr = readInt("Please input number: ");
			if (curr == SENTINEL) {
				println("Arithmetic progression!");
				break;
			}
			if (curr - last != diff) {
				println("Not an arithmetic progression!");
				break;
			}
			last = curr;
		}
	}

}
