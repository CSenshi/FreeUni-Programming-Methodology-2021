package exams.f2020.s2;

import acm.program.*;
import acm.util.RandomGenerator;

/*-
 * წარმოიდგინეთ, რომ კაზინოში რულეტს თამაშობთ.
 * 
 * რულეტის წესები მარტივია 0-დან 36-მდე(ჩათვლით) რიცხვებს შორის ერთერთს ირჩევთ და აკეთებთ ფსონს.
 * თუკი გაგიმართლათ და თქვენი არჩეული რიცხვი ამოვიდა მაშინ დადებულ ფსონზე 36-ჯერ მეტი გიბრუნდებათ. 
 * თუ არ გაგიმართლათ მაშინ დადებულ თანხას აგებთ.
 * 
 * წარმოიდგინეთ, რომ თავდაპირველად გაქვთ n ლარი და თამაშობთ მანამ სანამ ერთხელ არ მოიგებთ ან მანამ სანამ თანხა არ გაგითავდებათ. 
 * თამაშობთ შემდეგი სტრატეგიით:
 * ყოველ ჯერზე დებთ შემთხვევით რიცხვზე იმ ოდენობის თანხას რამდენიც გჭირდებათ იმისათვის, რომ მოგებაში გახვიდეთ,
 * თუკი საკმარისი თანხა გაქვთ. 
 * მაგალითად თუკი უკვე წაგებული გაქვთ x ლარი მაშინ იმდენი ლარი უნდა დადოთ, რომ x+1 ლარი მოიგოთ
 * (ჩათვალეთ, რომ კაზინო წილადი თანხის დადების საშუალებას გაძლევთ). 
 * თუკი საკმარისი თანხა არ გაქვთ მაშინ დებთ ყველას რაც გაქვთ. თავიდან ფსონად დებთ 1 ლარს.
 * 
 * გააკეთეთ ამ სტრატეგიის სიმულაცია და დათვალეთ რა არის ალბათობა იმისა, რომ კაზინოდან მოგებული გამოხვიდეთ. 
 * ყურადღება მიაქციეთ იმ ფაქტს, რომ ალბათობა გვაინტერესებს რისთვისაც ჩაატარეთ 1000 სიმულაცია.Ï
 */
public class M2020S2Ex2 extends ConsoleProgram {

	private final int TOTAL_SIMULATIONS = 1000;
	private final int STARTING_MONEY = 100;
	RandomGenerator rgen;

	@Override
	public void run() {
		this.setFont("-30");
		rgen = RandomGenerator.getInstance();
		double total_win_count = 0;
		for (int i = 0; i < TOTAL_SIMULATIONS; i++) {
			int k = simulate();
			total_win_count += k;
		}
		double result = total_win_count / TOTAL_SIMULATIONS;
		println(result);
	}

	private int simulate() {
		double n = STARTING_MONEY;
		while (true ) {
			if( n == 0) {
				return 0;
			}
			if(n > STARTING_MONEY) {
				println(n);
				return 1;
			}
			int ourChoice = generateNumber();
			double bet = generateBet(n);
			n -= bet;
			int rouletteChoice = generateNumber();

			if (ourChoice == rouletteChoice) {
				n += 36 * bet;
			}
		}
	}

	private double generateBet(double n) {
		if (n >= STARTING_MONEY) {
			return 1;
		}

		double bet = (STARTING_MONEY - n + 1) / 36;
		return Math.min(n, bet);
	}

	private int generateNumber() {
		return rgen.nextInt(0, 36);
	}

}
