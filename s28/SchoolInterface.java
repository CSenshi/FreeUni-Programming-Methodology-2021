package s28;

import java.util.ArrayList;
import java.util.Iterator;

public interface SchoolInterface {
	public void addTeacher(String teacher);

	public void addSubject(String teacher, String subject);

	public void addPupil(String pupil, String subject);

	public Iterator<String> getTeachers(String pupil);

	public Iterator<String> getPupils(String teacher);

	public void removeTeacher(String teacher);
}