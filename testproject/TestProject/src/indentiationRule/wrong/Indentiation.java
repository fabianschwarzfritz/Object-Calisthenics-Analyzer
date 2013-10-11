package indentiationRule.wrong;

public class Indentiation {
	public static void main(String[] args) {
		if (true) {
			StringBuilder thisIsStillAllowed = new StringBuilder();
			for (String string : args) {
				thisIsStillAllowed = thisIsStillAllowed.append(string);
			}
		}
	}
}
