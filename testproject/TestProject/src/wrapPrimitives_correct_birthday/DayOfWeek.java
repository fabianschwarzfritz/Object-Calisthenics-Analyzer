package wrapPrimitives_correct_birthday;

import java.io.PrintStream;

public class DayOfWeek {

	private Day day;
	private Name name;

	public DayOfWeek(Day day, Name name) {
		super();
		this.day = day;
		this.name = name;
	}

	public void print(PrintStream stream) {
		day.print(stream);
		stream.print(" day is a ");
		name.print(stream);
		stream.append("\n");
	}

}
