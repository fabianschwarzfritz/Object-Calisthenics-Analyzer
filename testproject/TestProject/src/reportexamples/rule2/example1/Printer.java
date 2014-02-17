package reportexamples.rule2.example1;

public class Printer {

	private Style style;

	public Printer(Style style) {
		this.style = style;
	}

	public void changeStyle(Style style) {
		this.style = style;
	}

	public void print(String string) {
		style.print(string);
	}

}
