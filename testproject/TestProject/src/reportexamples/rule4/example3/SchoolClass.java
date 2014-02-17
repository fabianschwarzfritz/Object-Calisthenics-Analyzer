package reportexamples.rule4.example3;

import java.util.List;

import reportexamples.rule4.example1.Student;

public class SchoolClass {

	private List<Student> students;

	public void changeName(int studentId, String name) {
		Student student = students.get(studentId);
		student.setName(name);
	}

}
