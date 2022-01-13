package s28;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class School implements SchoolInterface{

	private Map<String, List<String>> teachersSubjects;
	private Map<String, List<String>> subjectsPupils;

	/*
	 * კონსტრუქტორს არაფერი არ გადაეცემა. აქ შეგიძლიათ ინიციალიზაცია გაუკეთოთ
	 * თქვენთვის საჭირო ცვლადებს
	 */
	public School() {
		teachersSubjects = new HashMap<>();
		subjectsPupils = new HashMap<>();
	}

	/*
	 * addTeacher მეთოდის საშუალებით შეგიძლიათ სკოლას დაამატოთ ახალი მასწავლებელი.
	 * მეთოდს გადაეცემა მასწავლებლის სახელი. შეგიძლიათ ჩათვალოთ, რომ მასწავლებლის
	 * სახელი უნიკალურია.
	 */
	public void addTeacher(String teacher) {
		if (!teachersSubjects.containsKey(teacher)) {
			teachersSubjects.put(teacher, new ArrayList<String>());
		}
	}

	/*
	 * addSubject მეთოდის საშუალებით შეგიძლიათ მასწავლებელს დაუმატოთ საგანი. მეთოდს
	 * გადაეცემა მასწავლებლის სახელი და საგნის სახელი. ჩათვალეთ, რომ საგნის სახელი
	 * უნიკალურია. ერთი და იგივე მასწავლებელი შეიძლება რამდენიმე საგანს კითხულობდეს,
	 * ასევე ერთსა და იმავე საგანს შეიძლება რამდენიმე მასწავლებელი კითხულობდეს
	 * ერთდროულად. თუკი teacher სახელის მქონე მასწავლებელი არ არის აქამდე
	 * დამატებული, მაშინ მეთოდმა არაფერი არ უნდა გააკეთოს.
	 */
	public void addSubject(String teacher, String subject) {
		if (!teachersSubjects.containsKey(teacher)) {
			return;
		}
		teachersSubjects.get(teacher).add(subject);

		if (!subjectsPupils.containsKey(subject)) {
			subjectsPupils.put(subject, new ArrayList<String>());
		}
	}

	/*
	 * addPupil მეთოდის საშუალებით შეგიძლიათ საგანზე დაამატოთ მოსწავლე. ერთი და
	 * იგივე მოსწავლე შეიძლება ერთ ან რამდენიმე საგანს სწავლობდეს.
	 */
	public void addPupil(String pupil, String subject) {
		if (subjectsPupils.containsKey(subject)) {
			subjectsPupils.get(subject).add(pupil);
		}
	}

	/*
	 * getTeachers მეთოდს გადაეცემა მოსწავლის სახელი და მან უნდა დააბრუნოს ამ
	 * მოსწავლის ყველა მასწავლებელზე იტერატორი. ანუ მხოლოდ იმ მასწავლებლების
	 * სახელები, რომლებიც ასწავლიან იმ საგნებს, რომლებზეც მოსწავლეა
	 * დამატებული(სწავლობს). თუკი pupil სახელის მოსწავლე არ გვყავს მაშინ მეთოდმა
	 * უნდა დააბრუნოს null.
	 */
	public Iterator<String> getTeachers(String pupil) {
		// 1. pupil -> subjects (list)
		List<String> subjects = new ArrayList<>();

		for (String subjectName : subjectsPupils.keySet()) {
			List<String> pupils = subjectsPupils.get(subjectName);
			if (pupils.contains(pupil)) {
				subjects.add(subjectName);
			}
		}

		// 2. subjects -> teachers (list)
		List<String> teachers = new ArrayList<>();
		for (String teacher : teachersSubjects.keySet()) {
			List<String> teachersSubjectsList = teachersSubjects.get(teacher);
			if (hasIntersection(subjects, teachersSubjectsList)) {
				teachers.add(teacher);
			}
		}
		return teachers.iterator();
	}

	/*
	 * getPupils მეთოდს გადაეცემა მასწავლებლის სახელი და მან უნდა დააბრუნოს ამ
	 * მასწავლებლის ყველა სტუდენტზე იტერატორი. ანუ მხოლოდ იმ სტუდენტების სახელები,
	 * რომლებიც მის რომელიმე საგანს სწავლობენ. თუკი teacher სახელის მქონე ლექტორი არ
	 * გვყავს მაშინ მეთოდმა უნდა დააბრუნოს null.
	 */
	public Iterator<String> getPupils(String teacher) {
		List<String> subjects = teachersSubjects.get(teacher);
		List<String> pupils = new ArrayList<>();
		for (String subjectName : subjects) {
			List<String> subjectPupilsList = subjectsPupils.get(subjectName);
			for (String pupil : subjectPupilsList) {
				if (!pupils.contains(pupil)) {
					pupils.add(pupil);
				}
			}
		}
		return pupils.iterator();
	}

	/*
	 * მეთოდმა უნდა წაშალოს მასწავლებლის შესახებ ყველა ინფორმაცია. ამ მეთოდის
	 * გამოძახების, შემდეგ getTeachers მეთოდმა არ უნდა დააბრუნოს teacher სახელი არც
	 * ერთი სტუდენტისთვის.
	 */
	public void removeTeacher(String teacher) {
		teachersSubjects.remove(teacher);
	}

	private boolean hasIntersection(List<String> subjects, List<String> teachersSubjectsList) {
		for (String subject : subjects) {
			if (teachersSubjectsList.contains(subject)) {
				return true;
			}
		}
		return false;

	}
}
