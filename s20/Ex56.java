package s20;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;
import java.util.StringTokenizer;

import acm.program.ConsoleProgram;

/*-
 * კონსოლიდან შეგყვავს n და შემდეგ n ცალი მთელი რიცხვი, დაალაგეთ რიცხვები ზრდადობით და დაბეჭდეთ
 */
public class Ex56 extends ConsoleProgram {

	public void run() {
		// Input
		int input[] = readInput();
		println("\nBefore Sort: " + Arrays.toString(input));

		// Find first 2 maximums
		sort2(input);

		// Print
		println("After Sort: " + Arrays.toString(input));
	}

	private int[] readInput() {
		// 1. Read N
		int n = readInt("Input N: ");

		// 2. Read total of N integers
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = readInt("Input number #" + (i + 1) + ": ");
		}
		return arr;
	}

	// Solution 1
	private void sort1(int[] input) {
		for (int i = 0; i < input.length; i++) {
			// 1. Find Minimum
			int minIndex = i;
			for (int j = i + 1; j < input.length; j++) {
				if (input[minIndex] > input[j]) {
					minIndex = j;
				}
			}

			// 2. Swap minimum with i'th element
			int tmp = input[i];
			input[i] = input[minIndex];
			input[minIndex] = tmp;
		}
	}

	// Solution 2
	private void sort2(int[] input) {
		while (!isSorted(input)) {
			for (int i = 0; i < input.length - 1; i++) {
				if (input[i] > input[i + 1]) {
					int tmp = input[i];
					input[i] = input[i + 1];
					input[i + 1] = tmp;
				}
			}
		}
	}

	private boolean isSorted(int[] input) {
		for (int i = 0; i < input.length - 1; i++) {
			if (input[i] > input[i + 1]) {
				return false;
			}
		}
		return true;
	}
}