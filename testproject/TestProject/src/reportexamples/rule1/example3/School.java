package reportexamples.rule1.example3;

import java.util.List;

public class School {

	private List<SchoolClass> classes;

	private void count() {
		int sum = 0;
		for (SchoolClass classe : classes) {
			classe.countStudents(sum, classe);
		}
	}

	public static void main(String[] args) {
		School school = new School();
		school.count();
	}

}
