package reportexamples.rule2.example1;

public class ItalicFont implements Style {

	@Override
	public void print(String string) {
		System.out.println("<i>" + string + "</i>");
	}

}
