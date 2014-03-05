package wrapPrimitives_correct_birthday;

import java.io.PrintStream;

public class Day {

	private int day;

	public Day(int day) {
		this.day = day;
	}
	
	public void print(PrintStream print) {
		print.print(day);
	}
}
