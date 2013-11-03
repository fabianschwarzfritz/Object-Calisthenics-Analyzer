package wrapPrimitives_correct_birthday;

import java.io.PrintStream;

public class Birthday {

	private Day day;
	private Month month;

	public Birthday(Day day, Month month) {
		this.day = day;
		this.month = month;
	}

	public void print(PrintStream stream) {
		day.print(stream);
		stream.append("ter ");
		month.print(stream);
		stream.append("ter ");
		stream.append(" ist ein schoener Tag!\n");
	}

}
