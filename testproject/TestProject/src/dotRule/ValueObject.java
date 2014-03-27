package dotRule;

public class ValueObject {

	public String var;

	public ValueObject() {
		
	}

	public ValueObject(String var) {
		this.var = var;
	}

	public String method() {
		return var;
	}

}
