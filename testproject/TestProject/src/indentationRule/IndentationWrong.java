package indentationRule;

public class IndentationWrong {
	public static void main(String[] args) {
		if (true) {
			StringBuilder thisIsStillAllowed = new StringBuilder();
			for (String string : args) {
				thisIsStillAllowed = thisIsStillAllowed.append(string);
			}
		}
	}
}
