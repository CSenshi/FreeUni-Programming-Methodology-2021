package exams.m2021.s2;

import java.util.HashMap;
import java.util.Map;

import acm.program.*;

/*-
 * თქვენი ამოცანაა დაადგინოთ გადმოცემული სტრინგები ერთმანეთის ანაგრამები არიან თუ არა
 * 
 * ერთი ტექსტი მეორის ანაგრამაა, თუკი ორივე ტექსტის ჩასაწერად ერთი და იგივე ასოიების კრებულიგამოიყენება
 * და ერთი სიტყვიდან მეორის მიღება უბრალო ასოების გადაადგილებითაა შესაძლებელი
 */
public class M2021S2Ex02 extends ConsoleProgram {

	@Override
	public void run() {
		println(isAnagram("tokyo", "kyoto")); // უნდა დაბეჭდოს true
		println(isAnagram("bella", "label")); // უნდა დაბეჭდოს true
		println(isAnagram("hello", "hi")); // უნდა დაბეჭდოს false
	}

	private boolean isAnagram(String st1, String st2) {
		if (st1.length() != st2.length())
			return false;

		for (int i = 0; i < st1.length(); i++) {
			int index = st2.indexOf(st1.charAt(i));
			if (index == -1)
				return false;

			st2 = st2.substring(0, index) + st2.substring(index + 1, st2.length());
		}
		return st2.isEmpty();
	}

}
