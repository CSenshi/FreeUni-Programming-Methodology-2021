package exams.m2021.s1;

import acm.program.*;

/*-
 * დაადგინეთ არის თუ არა ლუკა ანაკინის შვილი
 * 
 * იპოვეთ ორივე სტრინგში მაქსიმალური სიგრძის ქვესტრინგი, რომელსაც ორივე სტრინგი შეიცავს.
 * 
 * თუ ეს ქვესტრინგის ანაკინის სტრინგის ზომის ნახევარზე მეტია, მაშინ ლუკა მისი შვილია, წინააღმდეგ შემთხვევაში არა
 * 
 * პ.ს. სტრინგში ქვესტრინგი არის მიმდევრობით, მაგალითად "ABCD"-ს ქვესტრინგი არის "BCD" მაგრამ არა "ACD" 
 */
public class M2021S1Ex02 extends ConsoleProgram {

	@Override
	public void run() {
		println(amIYourFatherLuke("CGAT", "CCTGACT"));
		println(amIYourFatherLuke("GATA", "TTGATTT"));
		println(amIYourFatherLuke("A", "AA"));
		println("=================================="); 
		println(amIYourFatherLuke("GATTA", "TTGATTT"));
		println(amIYourFatherLuke("ATGC", "TTGCA"));
		println(amIYourFatherLuke("AA", "AA"));
	}

	private boolean amIYourFatherLuke(String lukeDNA, String anakinDNA) {
		for (int i = 0; i < lukeDNA.length(); i++) {
			for (int j = i; j <= lukeDNA.length(); j++) {
				String currSubStr = lukeDNA.substring(i, j);
				if (anakinDNA.contains(currSubStr) && currSubStr.length() > anakinDNA.length() / 2) {
					return true;
				}
			}
		}
		return false;
	}
}
