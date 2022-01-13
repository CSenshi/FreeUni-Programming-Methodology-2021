package exams.f2020.s1;

import acm.program.*;

/*-
 * თქვენი ამოცანაა დაწეროთ rearrange მეთოდი,
 * რომელსაც გადაეცემა წინადადება და რომელიც აბრუნებს გადალაგებულ ტექსტს.
 * 
 * ჩათვალეთ, რომ წინადადება არის პატარა ლათინური ანბანით და სფეისებით შედგენილი სტრინგი. 
 * თქვენი ამოცანაა გადაცემულ წინადადებაში გადაალაგოთ სიტყვები მათი სიგრძის ზრდის მიხედვით. 
 * პირველი სიტყვა უნდა იყოს ყველაზე მოკლე, მეორე სიგრძით შემდეგი და ა.შ. ბოლო სიტყვა ყველაზე გრძელი. 
 * თუკი ორი სიტყვა ერთიდაიგივე სიგრძისაა, მაშინ მათი მიმდერობა არ უნდა შეიცვალოს 
 * (საწყის წინადადებაში უფრო ადრე რომელიც გვხვდებოდა ისევ ის უნდა შეგვხვდეს შედეგშიც). 
 * მეთოდმა უნდა დააბრუნოს გადალაგებული წინადადება. მაგალითები:
 * 	“keep calm and code on” -> “on and keep calm code”
 * 	“to be or not to be” -> “to be or to be not”
 * 	“exams rule” -> “rule exams”
 */
public class M2020S1Ex1 extends ConsoleProgram {

	@Override
	public void run() {
		String s = "to be or not to be";
		String result = rearange(s);
		println(result);
	}

	private String rearange(String s) {
		// 1. split by tokens
		String[] arr = s.split(" ");

		// 2. find max length token
		int maxLenToken = 0;
		for (int i = 0; i < arr.length; i++) {
			maxLenToken = Math.max(maxLenToken, arr[i].length());
		}

		// 3. create result string
		String result = "";
		for (int i = 0; i <= maxLenToken; i++) {
			for (int j = 0; j < arr.length; j++) {
				if (arr[j].length() == i) {
					result += arr[j] + " ";
				}
			}
		}
		return result.trim();
	}
}
