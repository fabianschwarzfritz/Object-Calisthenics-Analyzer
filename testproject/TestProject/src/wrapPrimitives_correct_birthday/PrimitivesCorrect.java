package wrapPrimitives_correct_birthday;

public class PrimitivesCorrect {

	public static void main(String[] args) {
		PrimitivesCorrect correct = new PrimitivesCorrect();
		correct.operation2();
	}

	private Birthday create2() {
		return new Birthday(new Day(15), new Month(10));
	}

	public void operation2() {
		Birthday birthday = create2();
		birthday.print(System.out);
	}
}
