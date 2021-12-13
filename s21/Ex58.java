package s21;

import java.util.ArrayList;
import java.util.List;

import acm.program.ConsoleProgram;

/*
 * (2018 წლის გამოცდის ამოცანა)
 * 
 * მატრიცას ეწოდება მაგიური თუკი ის კვადრატულია(n x n-ზე) და მასში არის ყველა რიცხვი 1-დან n^2-ის ჩათვლით.
 * 
 * თქვენი მიზანია დაწეროთ magicMatrix მეთოდი,
 * რომელიც შეამოწმებს არის თუ არა მატრიცა მაგიური და თუკი მაგიურია მაშინ დააბრუნებს true-ს თუ არა მაშინ false-ს.
 */
public class Ex58 extends ConsoleProgram {

	public void run() {
		this.setFont("-30");
		// 1. Input
		int[][] matrix = { { 3, 7, 3 }, { 1, 2, 6 }, { 5, 8, 4 } };

		// 2. Evaluate
		boolean result = magicMatrix(matrix);

		// 3. Print
		println(result);
	}

	private boolean magicMatrix(int[][] matrix) {
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < matrix.length * matrix.length; i++) {
			list.add(i + 1);
		}

		println(list);
		for (int[] curArray : matrix) {
			for (int curElem : curArray) {
				int index = list.indexOf(curElem);
				if (index == -1) {
					return false;
				}
				list.remove(index);
			}
		}
		println(list);
		
		return list.size() == 0;
	}

}