package reportexamples.rule2.example1;

public class Main {
	public static void main(String[] args) {
		Printer printer = new Printer(new BoldFont());
		printer.print("Fabian");
		printer.changeStyle(new ItalicFont());
		printer.print("Schwarz-Fritz");
	}
}
