package s18;

import acm.graphics.GOval;
import acm.program.ConsoleProgram;
import acm.program.GraphicsProgram;
import acm.util.RandomGenerator;

/*
 * მომხმარებელს კონსოლიდან შეჰყავს ტექსტი და სიმბოლო, 
 * თქვენმა პროგრამამ უნდა იპოვოს რამდენჯერ გვხვდება მოცემულ ტექსტში მოცემული სიმბოლო. 
 */
public class Ex45 extends ConsoleProgram {

	@Override
	public void run() {
		// input
		String text = readLine("text: ");
		char ch = readChar("char: ");

		// process
		int result = count(text, ch);

		// result
		println("Total: " + result);
	}

	private char readChar(String prompt) {
		String input = readLine(prompt);
		while (input.length() != 1) {
			input = readLine("Please input exactly 1 symbol: ");
		}
		return input.charAt(0);
	}

	private int count(String text, char ch) {
		int count = 0;
		for (int i = 0; i < text.length(); i++) {
			if (text.charAt(i) == ch)
				count++;
		}
		return count;
	}

}
