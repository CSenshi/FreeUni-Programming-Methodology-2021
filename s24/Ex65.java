package s24;

import acm.program.ConsoleProgram;

/*
 * კონსოლიდან შეგვყავს რიცხვები მანამ სანამ არ შეიყვანთ -1-ს, დაბეჭდეთ შეყვანილი რიცხვები შებრუნებული მიმდევრობით.
 */
public class Ex65 extends ConsoleProgram {

	/**
	 * 63-ე ამოცანის გაგრძელება.
	 * 
	 * დაბეჭდეთ ადამიანი რომელსაც ყველაზე მეტი ადამიანი ემეგობრება
	 */
	public void run() {
		FriendsList friendsList = new FriendsList(this);

		friendsList.readInput();
		println(friendsList.mostFriendly());
	}

}
