package exams.m2020;

import java.util.HashMap;
import java.util.Map;

import acm.program.*;

public class M2020Ex03 extends ConsoleProgram {

	@Override
	public void run() {
		 double n = sqrt(6.25);
		 println(n);
		 n = sqrt(64);
		 println(n);
		 n = sqrt(100);
		 println(n);
		 n = sqrt(256);
		 println(n);
	}

	private double sqrt(double input) {
		double l = 1, r = input;
		int c = 0;
		while(true) {
			double m = (l + r) / 2;
			double squared = m * m;
			if(squared == input) {
				return m;
			}else if (squared < input) {
				l = m;
			}else {
				r = m;
			}
			
			// extra return to finish execution
			// because it's imposible to get exact number
			// WAS NOT REQUIRED IN EXAMS!!!
			if(c++ > 50){
				return m;
			}
		}
	}
}
