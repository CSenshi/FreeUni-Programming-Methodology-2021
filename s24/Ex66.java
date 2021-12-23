package s24;

import acm.program.ConsoleProgram;

/**
 * 63-ე ამოცანის გაგრძელება.
 * 
 * დაბეჭდეთ ორი ადამინი რომელთაც არ ჰყავთ საერთო მეგობრები
 */
public class Ex66 extends ConsoleProgram {

	public void run() {
		FriendsList friendsList = new FriendsList(this);

		friendsList.readInput();
		println(friendsList.usersWithNoMutualFriends());
	}

}
