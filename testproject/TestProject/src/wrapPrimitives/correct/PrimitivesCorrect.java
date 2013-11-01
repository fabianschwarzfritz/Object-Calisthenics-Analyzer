package wrapPrimitives.correct;

public class PrimitivesCorrect {

	public static void main(String[] args) {
		PrimitivesCorrect correct = new PrimitivesCorrect();
		correct.operation1();
		correct.operation2();
	}

	private Birthday create1() {
		return new Birthday(15, 10);
	}

	private Birthday create2() {
		return new Birthday(new Day(15), new Month(10));
	}

	public void operation1() {
		Birthday birthday = create1();
		birthday.print(System.out);
	}

	public void operation2() {
		Birthday birthday = create2();
		birthday.print(System.out);
	}
}
