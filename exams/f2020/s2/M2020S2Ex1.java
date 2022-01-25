package exams.f2020.s2;

import java.util.*;

import acm.program.*;

/*-
 * დაწერეთ მეთოდი power, რომელსაც გადაეცემა სტრინგი და მთელი რიცხვი k და რომელიც აბრუნებს რიცხვს.
 * 
 * შემავალი სტრინგის ქვესტრინგს, რომელიც ზუსტად k განსხვავებული სიმბოლოსგან შედგება, 
 * (შეიძლება ეს სიმბოლოები რამდენჯერმე იყოს გამოყენებიული ქვესტრინგში) დავარქვათ ხარისხიანი. 
 * 
 * თქვენი ამოცანაა იპოვოთ ყველაზე გრძელი ხარისხიანი ქვესტრინგი და დააბრუნოთ მისი სიგრძე.
 * 
 * მაგალითად:
 * სტრინგი “abbcccddddeeeeedcba” და k=1-ისთვის მეთოდმა უნდა დააბრუნოს 5(“eeeee”)
 * სტრინგი “triplepillooooow” და k=2-ისთვის მეთოდმა უნდა დააბრუნოს 7(“llooooo”)
 * სტრინგი “freeeunnii” და k=3-ისთვის მეთოდმა უნდა დააბრუნოს 6(“eeeunn”)
 * სტრინგი “abcd” და k=5-ისთვის მეთოდმა უნდა დააბრუნოს 0 - ხარისხიანი ქვესტრინგი არ გვაქვს.
 */
public class M2020S2Ex1 extends ConsoleProgram {

	@Override
	public void run() {
		this.setFont("-30");
		println(power("abbcccddddeeeeedcba", 1)); // 5
		println(power("triplepillooooow", 2)); // 7
		println(power("freeeunnii", 3)); // 6
		println(power("abcd", 5)); // 0

	}

	private int power(String s, int k) {
		int res = 0;
		for (int i = 0; i < s.length(); i++) {
			for (int j = i + 1; j <= s.length(); j++) {
				String substr = s.substring(i, j);
				int uniqueCharsCount = getUniqueCharsCount(substr);
				if (uniqueCharsCount == k) {
					res = Math.max(res, substr.length());
				}
			}
		}
		return res;
	}

	private int getUniqueCharsCount(String s) {
		Set<Character> set = new HashSet<>();
		for (int i = 0; i < s.length(); i++) {
			set.add(s.charAt(i));
		}
		return set.size();
	}
}
