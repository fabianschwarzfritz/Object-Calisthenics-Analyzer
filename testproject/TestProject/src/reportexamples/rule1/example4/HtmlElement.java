package reportexamples.rule1.example4;

import java.io.PrintStream;

public class HtmlElement {

	private int id;
	private String message;

	public HtmlElement(String string) {
		this.message = string;
	}

	public void print(PrintStream print) {
		increateId();
		print.append("<html id=\"" + id + "\">");
		print.append(message);
		print.append("<html>");
	}

	private void increateId() {
		++id;
	}

}
