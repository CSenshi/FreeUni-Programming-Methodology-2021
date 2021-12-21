package s24;

import acm.program.ConsoleProgram;

/*
 * კონსოლიდან შეგვყავს რიცხვები მანამ სანამ არ შეიყვანთ -1-ს, დაბეჭდეთ შეყვანილი რიცხვები შებრუნებული მიმდევრობით.
 */
public class Ex64 extends ConsoleProgram {

	/**
	 * 63-ე ამოცანის გაგრძელება.
	 * 
	 * დაბეჭდეთ თითოეული შეყვანილი სახელი და მის გასწვრივ მძიმით გამოყოფილი
	 * მეგობრების სია.
	 */
	public void run() {
		FriendsList friendsList = new FriendsList(this);

		friendsList.readInput();
		friendsList.printFriends();
	}

}
