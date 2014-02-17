package reportexamples.rule1.example1;

import java.util.List;

public class School {

	private List<SchoolClass> classes;

	private void count() {
		int sum = 0;
		for (SchoolClass classe : classes) {
			List<Student> students = classe.getStudents();
			for (Student stuent : students) {
				++sum;
			}
		}
	}

	public static void main(String[] args) {
		School school = new School();
		school.count();
	}

}
