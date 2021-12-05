package exams.m2021.s1;

import acm.program.*;

/*-
 * n ^ x = m (n ხარისხად x = m)
 * x = log(n, m)
 * 
 * დაწერეთ მეთოდი, რომელსაც გადაეცემა 2 მთელი რიცხვი 
 * და რომელიც აბრუნებს ამ რიცხვებისთვის ლოგარითმის მთელ ნაწილს 
 * 
 */

public class M2021S1Ex01 extends ConsoleProgram {

	@Override
	public void run() {
		println(log(2, 8)); // უნდა დაბეჭდოს 3
		println(log(2, 12)); // უნდა დაბეჭდოს 3
		println(log(3, 8)); // უნდა დაბეჭდოს 1
	}

	private int log(int n, int m) {
		int x = n;
		int res = 1;

		while (x <= m) {
			x *= n;
			res++;
		}

		return res - 1;
	}

}
