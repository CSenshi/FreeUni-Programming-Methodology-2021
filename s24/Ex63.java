package s24;

import acm.program.ConsoleProgram;

/**
 * კონსოლიდან შეგვყავს წყვილ-წყვილად მეგობრების სახელები, მანამ სანამ არ
 * შევიყვანთ ცარიელ სტრინგს. დაბეჭდეთ იმ ადამიანის სახელი ვისაც ჰყავს ყველაზე
 * მეტი მეგობარი.
 * 
 * მეგობრობა შეიძლება იყოს ცალმხრივი. თუკი შევიყვანთ A-ს და B-ს, ეს ნიშნავს, რომ
 * A არის B-ს მეგობარი, მაგრამ B შეიძლება არ იყოს A-ს მეგობარი.
 * 
 * შენიშვნა: წყვილ-წყვილად შეყვანაში იგულისხმება სფეისით დაშორებული ორი სახელის
 * შეყვანა. მაგალითად: "John Mary" -> John არის Mary-ის მეგობარი
 */
public class Ex63 extends ConsoleProgram {

	public void run() {
		FriendsList friendsList = new FriendsList(this);

		friendsList.readInput();
		println(friendsList.mostPopular());
	}

}