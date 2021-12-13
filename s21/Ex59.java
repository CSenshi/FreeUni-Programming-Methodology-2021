package s21;

import java.util.Arrays;

import acm.program.ConsoleProgram;

/*
 *(2018 წლის გამოცდის ამოცანა)
 * გადმოგეცემათ nxm-ზე მატრიცა რომელშიც მხოლოდ 0-ები და 1-ები წერია. 
 * მეთოდმა უნდა დააბრუნოს ამ მატრიცის ყველაზე დიდი ქვემართკუთხედის ზომა(ელემენტების რაოდენობა),
 * რომელიც მხოლოდ 1-ებისგან შედგება.
 *  
 *  მაგალითად:
 *  01100100
 *  01111100
 *	00111100
 *	00111100
 *
 *	ამ მატრიცაში ყველაზე დიდი შიდა მართკუთხედი, რომელიც სულ ერთიანებისგან შედგება არის 12 ზომის:
 *  
 *  01 1001 00
 *  01|1111|00
 *	00|1111|00
 *	00|1111|00
 *
 *  შესაბამისად ამ მატრიცაზე მეთოდმა უნდა დააბრუნოს 12. 
 *  ჩათვალეთ რომ გადმოცემულ მატრიცაში ერთი უჯრა მაინც იქნება რომელშიც წერია 1.
 */
public class Ex59 extends ConsoleProgram {

	public void run() {
		this.setFont("-30");
		// Input
		int[][] matrix = { 
				{ 0, 1, 1, 0, 0, 1, 0, 0 }, 
				{ 0, 1, 1, 1, 1, 1, 0, 0 }, 
				{ 0, 0, 1, 1, 1, 1, 0, 0 },
				{ 0, 0, 1, 1, 1, 1, 0, 0 }, };

		// Evaluate
		int result = getMaxSquare(matrix);

		// Print
		println(result);
	}

	private int getMaxSquare(int[][] matrix) {
		int maxArea = 0;
		for (int x1 = 0; x1 < matrix.length; x1++) {
			for (int y1 = 0; y1 < matrix[x1].length; y1++) {
				// (x1, y1)

				for (int x2 = x1; x2 < matrix.length; x2++) {
					for (int y2 = y1; y2 < matrix[x2].length; y2++) {
						// (x2, y2)

						if (isSquare(x1, y1, x2, y2, matrix)) {
							int area = (x2 - x1 + 1) * (y2 - y1 + 1);
							if (area > maxArea) {
								int[] arrr ={x1,y1,x2,y2};
								println(Arrays.toString(arrr));
								maxArea = area;
							}
						}
					}
				}
			}
		}
		return maxArea;
	}

	private boolean isSquare(int x1, int y1, int x2, int y2, int[][] matrix) {
		for (int i = x1; i <= x2; i++) {
			for (int j = y1; j <= y2; j++) {
				if (matrix[i][j] == 0) {
					return false;
				}
			}
		}
		return true;
	}

}