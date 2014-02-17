package primitiveWrapper;

public class Amount {

	private int value;
	private String kind;

	public Amount(int value, String kind) {
		super();
		this.value = value;
		this.kind = kind;
	}

	public boolean isSame(int value, String kind) {
		return this.value == value && this.kind.equals(kind);
	}

	public void print(StringBuffer stream) {
		stream.append(value + " " + kind);
	}

}
