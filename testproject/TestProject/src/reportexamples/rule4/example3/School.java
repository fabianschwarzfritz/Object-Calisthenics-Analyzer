package reportexamples.rule4.example3;

import java.util.List;

public class School {

	private List<SchoolClass> classes;

	public void changeName(int schoolclazzId, int studentId, String name) {
		SchoolClass schoolClass = classes.get(schoolclazzId);
		schoolClass.changeName(studentId, name);
	}

	public static void main(String[] args) {
		School school = new School();
		school.changeName(0, 0, "Affe");
	}

}
