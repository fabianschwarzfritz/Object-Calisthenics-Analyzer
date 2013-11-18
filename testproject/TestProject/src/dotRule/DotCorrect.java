package dotRule;

public class DotCorrect {

	private static ValueObject localObject = new ValueObject();

	public static void main(String[] args) {
		ValueObject valueObject = new ValueObject();

		String var = valueObject.var;
		valueObject.method();
		localObject.var = "asdf";
	}
}
