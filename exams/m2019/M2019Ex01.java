package exams.m2019;

import acm.program.ConsoleProgram;

/*-
 * გამოთვალეთ შემდეგი ჯავა გამოსახულებები. 
 * 
 * იმ შემთხვევაში თუკი ადგილი აქვს შეცდომას გამოსახულებაში, 
 * მიუთითეთ და მოკლედ ახსენით რა სახის შეცდომასთან გვაქვს საქმე
 */
public class M2019Ex01 extends ConsoleProgram {

	@Override
	public void run() {
		println(12 / 5 + 2.4 / 2 + 2 / 5); // 3.2
		println(5 % 2 == 0 && 4 > 5 - 6); // false
		println('d' + 1 - 'a' + "E" + 3 + 2 + 'b'); // "4E32b"
	}

}
