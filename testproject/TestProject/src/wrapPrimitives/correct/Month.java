package wrapPrimitives.correct;

import java.io.PrintStream;

public class Month {

	private int month;

	public Month(int month) {
		this.month = month;
	}

	public void print(PrintStream print) {
		print.print(month);
	}
}
