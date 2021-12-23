package s24;

import acm.program.ConsoleProgram;

/**
 * 63-ე ამოცანის გაგრძელება.
 * 
 * დაბეჭდეთ ადამიანი რომელსაც ყველაზე მეტი ადამიანი ემეგობრება
 */
public class Ex65 extends ConsoleProgram {

	public void run() {
		FriendsList friendsList = new FriendsList(this);

		friendsList.readInput();
		println(friendsList.mostFriendly());
	}

}
