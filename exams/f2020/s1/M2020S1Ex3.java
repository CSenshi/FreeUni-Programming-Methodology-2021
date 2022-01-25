package exams.f2020.s1;

import java.util.*;

import acm.program.*;

/*-
 * მოცემული გაქვთ მეგობრები Map<String, ArrayList<String>> სახით, 
 * მეფის key არის სტუდენტის სახელი, ხოლო მისი value ამ სტუდენტის მეგობრების სია(რომლებიც ასევე სტუდენტები არიან).
 * 
 * ასევე მოცემული გაქვთ თითოეული სტუდენტის შეფასებები სხვადასხვა საგნებში Map<String, Map<String, Double>> სახით,
 * სადაც key არის სტუდენტის სახელი ხოლო value კი შეფასებების მეფი. 
 * შეფასებების მეფში key არის საგნის სახელი, ხოლო value ნიშანი რომელიც ამ საგანში მიიღო სტუდენტმა. 
 * 
 * ჩათვალეთ, რომ მეგობრობა ორმხრივია. კურსის საშუალო ქულა არის ყველა სტუდენტის მიერ ამ კურსში მიღებული ქულების საშუალო
 * (იმ სტუდენტების, რომლებიც ამ კურსს გადიოდნენ). 
 * ყველა კურსის საშუალო ქულა არის თითოეული კურსის საშუალო ქულების საშუალო
 * (ანუ თითოეული კურსის საშუალო ქულების ჯამი გაყოფილი კურსების რაოდენობაზე).
 * 
 * კარგი კურსი დავარქვათ კურსს, თუ ამ კურსის საშუალო ქულა მეტია ყველა კურსის საშუალო ქულაზე. 
 * 
 * იპოვეთ ისეთი სტუდენტი, რომლის ყველა მეგობარსაც მხოლოდ კარგი კურსები აქვს გავლილი. 
 * თუკი ასეთი სტუდენტი რამდენიმეა მაშინ დააბრუნეთ ერთ-ერთი. 
 * თუკი ასეთი სტუდენტი არ არსებობს მაშინ დააბრუნეთ ცარიელი სტრინგი.
 */
public class M2020S1Ex3 extends ConsoleProgram {

	@Override
	public void run() {
		this.setFont("-30");

	}

	public String luckyStudent(Map<String, List<String>> friends, Map<String, Map<String, Double>> scores) {
		List<String> goodCourses = goodCourses(scores);

		for (String student : friends.keySet()) {
			if (isLuckyStudent(student, friends, scores, goodCourses)) {
				return student;
			}
		}
		return "";
	}

	private boolean isLuckyStudent(String student, Map<String, List<String>> friends,
			Map<String, Map<String, Double>> scores, List<String> goodCourses) {
		List<String> studentsFriends = friends.get(student);

		for (String studentName : studentsFriends) {
			Map<String, Double> studentsCoursesScores = scores.get(studentName);
			for (String courseName : studentsCoursesScores.keySet()) {
				if (!goodCourses.contains(courseName)) {
					return false;
				}
			}
		}
		return true;
	}

	private List<String> goodCourses(Map<String, Map<String, Double>> scores) {
		double allCourseAverage = calculateAllCourseAverage(scores);
		List<String> allCourses = getAllCourses(scores);

		List<String> goodCourses = new ArrayList<>();
		for (String courseName : allCourses) {
			double courseAverage = calculateCourseAverage(courseName, scores);
			if (courseAverage > allCourseAverage) {
				goodCourses.add(courseName);
			}
		}
		return goodCourses;
	}

	private double calculateAllCourseAverage(Map<String, Map<String, Double>> scores) {
		List<String> allCourses = getAllCourses(scores);
		double sum = 0;
		for (String courseName : allCourses) {
			sum += calculateCourseAverage(courseName, scores);
		}
		return sum / allCourses.size();
	}

	private List<String> getAllCourses(Map<String, Map<String, Double>> scores) {
		List<String> allCourses = new ArrayList<>();

		for (String studentName : scores.keySet()) {
			Map<String, Double> courseScores = scores.get(studentName);
			for (String courseName : courseScores.keySet()) {
				if (!courseScores.containsKey(courseName)) {
					allCourses.add(courseName);
				}
			}
		}

		return allCourses;
	}

	private double calculateCourseAverage(String courseName, Map<String, Map<String, Double>> scores) {
		double sum = 0;
		int students = 0;

		for (String studentName : scores.keySet()) {
			Map<String, Double> courseScores = scores.get(studentName);
			if (courseScores.containsKey(courseName)) {
				sum += courseScores.get(courseName);
				students++;
			}
		}

		return sum / students;

	}

}
