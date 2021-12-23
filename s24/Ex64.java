package s24;

import acm.program.ConsoleProgram;

/**
 * 63-ე ამოცანის გაგრძელება.
 * 
 * დაბეჭდეთ თითოეული შეყვანილი სახელი და მის გასწვრივ მძიმით გამოყოფილი
 * მეგობრების სია.
 */
public class Ex64 extends ConsoleProgram {

	public void run() {
		FriendsList friendsList = new FriendsList(this);

		friendsList.readInput();
		friendsList.printFriends();
	}

}
