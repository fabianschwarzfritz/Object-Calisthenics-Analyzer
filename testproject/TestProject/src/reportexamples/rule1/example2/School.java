package reportexamples.rule1.example2;

import java.util.List;

public class School {

	private List<SchoolClass> classes;

	private void count() {
		int sum = 0;
		for (SchoolClass classe : classes) {
			sum = countStudents(sum, classe);
		}
	}

	private int countStudents(int sum, SchoolClass classs) {
		List<Student> students = classs.getStudents();
		for (Student stuent : students) {
			++sum;
		}
		return sum;
	}

	public static void main(String[] args) {
		School school = new School();
		school.count();
	}

}
