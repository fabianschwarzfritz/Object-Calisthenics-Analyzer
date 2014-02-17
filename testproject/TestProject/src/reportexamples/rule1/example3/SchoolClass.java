package reportexamples.rule1.example3;

import java.util.List;

public class SchoolClass {

	private List<Student> students;

	public int countStudents(int sum, SchoolClass classs) {
		for (Student stuent : students) {
			++sum;
		}
		return sum;
	}

}
