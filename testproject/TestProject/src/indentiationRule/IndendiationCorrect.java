package indentiationRule;

public class IndendiationCorrect {
	public static void main(String[] args) {
		StringBuilder thisIsStillAllowed = new StringBuilder();
		for (String string : args) {
			thisIsStillAllowed = thisIsStillAllowed.append(string);
		}
	}
}
