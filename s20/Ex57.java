package s20;

import java.util.Arrays;

import acm.program.ConsoleProgram;

/*
 * დაწერეთ მეთოდი, რომელსაც გადაეცემა ორი სტრინგი და აბრუნებს true-ს,
 * თუკი ეს ორის სტრინგი ერთმანეთის ანაგრამაა, ხოლო წინააღმდე შემთხვევაში აბრუნებს false-ს.
 * 
 * ჩათვალეთ, რომ ორივე სტრინგი მხოლოდ ლათინური ალფავიტის პატარა ასოებისგან შედგება.
 * 
 * იმპლემენტაცია გააკეთეთ მასივების გამოყენებით შემდეგი ალგორითმით: 
 * 		თითოეული სიტყვისთვის დათვალეთ თითოეული სიმბოლოს რაოდენობა(‘a’-‘z’) და შეინახეთ მასივში.
 * 		შემდეგ შეადარეთ ერთმანეთს მასივები.
 */
public class Ex57 extends ConsoleProgram {

	private final int NUM_CHARS = 26;

	public void run() {
		// Input
		String s1 = readLine("Input String #1: ");
		String s2 = readLine("Input String #2: ");

		// Evaluate
		boolean result = isAnagram1(s1, s2);

		// Print
		println(result);
	}

	// Solution 1
	private boolean isAnagram1(String s1, String s2) {
		int[] chars1 = countChars(s1);
		int[] chars2 = countChars(s2);

		for (int i = 0; i < NUM_CHARS; i++) {
			if (chars1[i] != chars2[i]) {
				return false;
			}
		}
		return true;
	}

	private int[] countChars(String s) {
		int[] counts = new int[NUM_CHARS];
		for (int i = 0; i < s.length(); i++) {
			int index = s.charAt(i) - 'a';
			counts[index]++;
		}
		return counts;
	}

	private boolean isAnagram2(String s1, String s2) {
		int[] arr = new int[26];

		for (int i = 0; i < s1.length(); i++) {
			arr[s1.charAt(i) - 'a']++;
		}

		for (int i = 0; i < s2.length(); i++) {
			arr[s2.charAt(i) - 'a']--;
		}

		for (int i = 0; i < 26; i++) {
			if (arr[i] != 0) {
				return false;
			}
		}

		return true;

	}
}