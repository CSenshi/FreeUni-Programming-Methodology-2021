package exams.f2020.s2;

import java.util.*;

import acm.program.*;

/*-
 * მოცემული გაქვთ მეგობრები Map<String, ArrayList<String>> სახით, 
 * მეფის key არის სტუდენტის სახელი, ხოლო მისი value ამ სტუდენტის მეგობრების სია(რომლებიც ასევე სტუდენტები არიან). 
 * 
 * ასევე მოცემული გაქვთ თითოეული სტუდენტის შეფასებები სხვადასხვა საგნებში Map<String, Map<String, Double>> სახით,
 * სადაც key არის სტუდენტის სახელი ხოლო value კი შეფასებების მეფი. შეფასებების მეფში key არის საგნის სახელი, ხოლო value ნიშანი რომელიც ამ საგანში მიიღო სტუდენტმა. 
 * 
 * ჩათვალეთ, რომ მეგობრობა ორმხრივია. 
 * A სტუდენტს დავარქვათ B სტუდენტის კარგი მეგობარი, თუკი A და B მეგობრები არიან და მინიმუმ 5 კურსი მაინც არსებობს, 
 * რომლებიც ორთავემ გაიარეს და სადაც ორთავემ 51-ზე მეტი ქულა მიიღეს.
 * 
 * იპოვეთ სტუდენტი, რომელსაც ყველაზე მეტი კარგი მეგობარი ჰყავს.
 * ამისათვის დაწერეთ მეთოდი goodFriends, რომელსაც გადაეცემა ორი მეფი და აბრუნებს სტრინგს - სტუდენტის სახელს.
 * თუკი რამდენიმე სტუდენტია, რომელთაც ერთიდაიგივე რაოდენობის კარგი მეგობრები ჰყავთ მაშინ დააბრუნეთ ერთერთი.
 * თუკი არც ერთ სტუდენტს კარგი მეგობარი არ ჰყავს მაშინ დააბრუნეთ ცარიელი სტრინგი.
 */
public class M2020S2Ex3 extends ConsoleProgram {

	@Override
	public void run() {
		this.setFont("-30");

	}

	public String goodFriends(Map<String, List<String>> friends, Map<String, Map<String, Double>> scores) {
		String maxGoodFriendsStudentName = "";
		int maxGoodFriendsCount = 0;
		for (String studentName : friends.keySet()) {
			int goodFriendsCount = getGoodFriendsCount(studentName, friends, scores);
			if (goodFriendsCount > maxGoodFriendsCount) {
				maxGoodFriendsCount = goodFriendsCount;
				maxGoodFriendsStudentName = studentName;
			}
		}
		return maxGoodFriendsStudentName;
	}

	private int getGoodFriendsCount(String studentName, Map<String, List<String>> friends,
			Map<String, Map<String, Double>> scores) {
		List<String> studentsFriends = friends.get(studentName);
		int count = 0;
		for (String friendStudentName : studentsFriends) {
			if (isGoodFriend(studentName, friendStudentName, scores)) {
				count++;
			}
		}
		return count;
	}

	private boolean isGoodFriend(String studentName, String friendStudentName,
			Map<String, Map<String, Double>> scores) {
		int count = 0;
		Map<String, Double> student1Scores = scores.get(studentName);
		Map<String, Double> student2Scores = scores.get(friendStudentName);

		for (String courseName : student1Scores.keySet()) {
			if (student2Scores.containsKey(courseName)) {
				// both students are taking this course
				if (student1Scores.get(courseName) > 51 && student2Scores.get(courseName) > 51) {
					count++;
				}
			}
		}

		return count >= 5;
	}

}
