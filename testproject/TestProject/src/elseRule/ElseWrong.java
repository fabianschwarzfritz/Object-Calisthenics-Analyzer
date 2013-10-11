package elseRule;

public class ElseWrong {
	public static void main(String[] args) {
		String var = new String("asdf");
		if (args[2].equals(var)) {
			var = "asdf";
		} else {
			var = "@@@@@";
		}
		return;
	}
}
