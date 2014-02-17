package reportexamples.rule4.example2;

import java.util.List;

import reportexamples.rule4.example1.SchoolClass;
import reportexamples.rule4.example1.Student;

public class School {

	private List<SchoolClass> classes;

	public List<SchoolClass> getClasses() {
		return classes;
	}

	public static void main(String[] args) {
		School school = new School();
		List<SchoolClass> classes = school.getClasses();
		SchoolClass searchedClass = classes.get(0);
		List<Student> searchedStudents = searchedClass.getStudents();
		Student affe = searchedStudents.get(0);
		affe.setName("Affe");
	}

}
