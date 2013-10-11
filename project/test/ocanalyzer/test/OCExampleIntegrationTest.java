package ocanalyzer.test;

import junit.framework.Test;
import junit.framework.TestSuite;
import ocanalyzer.test.integration.IntegrationTestElse;
import ocanalyzer.test.integration.IntegrationTestIndentation;

public class OCExampleIntegrationTest {

	public static Test suite() {
		TestSuite suite = new TestSuite("org.ocanalyzer.integration");
		suite.addTestSuite(IntegrationTestElse.class);
		suite.addTestSuite(IntegrationTestIndentation.class);
		return suite;
	}
}
