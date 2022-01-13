package exams.f2020.s1;

import acm.program.*;
import acm.util.RandomGenerator;

/*-
 * წარმოიდგინეთ, რომ კაზინოში რულეტს თამაშობთ.
 * რულეტის წესები მარტივია 0-დან 36-მდე(ჩათვლით) რიცხვებს შორის ერთერთს ირჩევთ და აკეთებთ ფსონს.
 * თუკი გაგიმართლათ და თქვენი არჩეული რიცხვი ამოვიდა მაშინ დადებულ ფსონზე 36-ჯერ მეტი გიბრუნდებათ.
 * თუ არ გაგიმართლათ მაშინ დადებულ თანხას აგებთ.
 * 
 * წარმოიდგინეთ, რომ თავდაპირველად გაქვთ n ლარი და თამაშობთ მანამ სანამ ყველას არ წააგებთ.
 * თამაშობთ შემდეგი სტრატეგიით: 
 * ყოველ ჯერზე დებთ შემთხვევით რიცხვზე იმ ოდენობის თანხას რამდენიც გჭირდებათ იმისათვის, რომ მოგებაში გახვიდეთ, 
 * თუკი ამის თანხა გყოფნით. 
 * მაგალითად თუკი უკვე ჯამში წაგებული გაქვთ x ლარი, მაშინ იმდენი ლარი უნდა დადოთ, რომ x+1 ლარი მოიგოთ
 * (ჩათვალეთ, რომ კაზინო წილადი თანხის დადების საშუალებას გაძლევთ). 
 * 
 * თუკი თანხა არ გყოფნით მაშინ ფსონად დებთ ყველას რაც გაქვთ. 
 * 
 * თუკი წაგებაში არ ხართ მაშინ დებთ 1 ლარს. 
 * გააკეთეთ ამ სტრატეგიის სიმულაცია და დათვალეთ საშუალოდ რამდენ დადებაში დაამთავრებთ თამაშს. 
 * ყურადღება მიაქციეთ იმ ფაქტს, რომ საშუალო გვაინტერესებს რისთვისაც ჩაატარეთ 1000 სიმულაცია.
 */
public class M2020S1Ex2 extends ConsoleProgram {

	private final int TOTAL_SIMULATIONS = 1000;
	private final int STARTING_MONEY = 100;
	RandomGenerator rgen;

	@Override
	public void run() {
		this.setFont("-30");
		rgen = RandomGenerator.getInstance();
		double total_loss = 0;
		for (int i = 0; i < TOTAL_SIMULATIONS; i++) {
			int k = simulate();
			total_loss += k;
		}
		double result = total_loss / TOTAL_SIMULATIONS;
		println(result);
	}

	private int simulate() {
		int count = 0;
		double n = STARTING_MONEY;
		while (n > 0) {
			int ourChoice = generateNumber();
			double bet = generateBet(n);
			n -= bet;
			int rouletteChoice = generateNumber();

			if (ourChoice == rouletteChoice) {
				n += 36 * bet;
			}
			count++;
		}
		return count;
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
