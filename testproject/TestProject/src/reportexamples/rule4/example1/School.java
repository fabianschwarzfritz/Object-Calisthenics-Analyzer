package reportexamples.rule4.example1;

import java.util.List;

public class School {

	private List<SchoolClass> classes;

	public List<SchoolClass> getClasses() {
		return classes;
	}

	public static void main(String[] args) {
		School school = new School();
		school.getClasses().get(0).getStudents().get(0).setName("Affe");
	}

}
