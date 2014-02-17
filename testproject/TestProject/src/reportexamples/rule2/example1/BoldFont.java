package reportexamples.rule2.example1;

public class BoldFont implements Style {

	@Override
	public void print(String string) {
		System.out.println("<b>" + string + "</b>");
	}

}
