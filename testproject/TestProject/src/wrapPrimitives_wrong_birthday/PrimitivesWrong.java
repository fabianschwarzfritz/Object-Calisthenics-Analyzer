package wrapPrimitives_wrong_birthday;

public class PrimitivesWrong {

	public static void main(String[] args) {
		PrimitivesWrong wrong = new PrimitivesWrong();
		wrong.operation();
	}

	public void operation() {
		int day = 15;
		int month = 10;

		System.out.println("Fabian's Birthday: " + day + "." + month);
	}
}
