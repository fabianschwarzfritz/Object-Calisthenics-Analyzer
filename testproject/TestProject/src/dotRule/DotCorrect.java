package dotRule;

public class DotCorrect {

	private String value;

	public DotCorrect() {
		this.value = "asdf";
		value = "2345";
	}

	private static ValueObject localObject = new ValueObject();

	public static void main(String[] args) {
		ValueObject valueObject = new ValueObject();

		String var = valueObject.var;
		valueObject.method();
		localObject.var = "asdf";
	}
}
