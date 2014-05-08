package dotRule;

public class DotWrong {

	public static void main(String[] args) {
		ValueObject valueObject = new ValueObject();
		ValueObject valueObject2 = new ValueObject(new String("asdf").toLowerCase().toLowerCase()); //x
		ValueObject valueObject3 = new ValueObject(new String(new String("asdf").toLowerCase().toLowerCase()).toLowerCase().toLowerCase());//x

		String var = valueObject.var.toLowerCase(); // x
		valueObject.method().toCharArray(); //x
		System.out.println("asdfasdf"); //x

		valueObject.var.toString().toLowerCase(); // x
	}
}
