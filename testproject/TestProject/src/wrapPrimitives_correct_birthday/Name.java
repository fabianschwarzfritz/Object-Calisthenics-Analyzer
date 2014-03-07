package wrapPrimitives_correct_birthday;

import java.io.PrintStream;

public class Name {

	private String name;

	public Name(String name) {
		this.name = name;
	}

	public void print(PrintStream stream) {
		stream.print(name);
	}

}
