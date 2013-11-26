package ocanalyzer.newIntegration;

import org.junit.Test;

public class ElseIntegration extends OCIntegration {

	public ElseIntegration(String packageName) {
		super(packageName);
	}

	@Test
	public void test() {
		rules.apply(units);
	}

}
