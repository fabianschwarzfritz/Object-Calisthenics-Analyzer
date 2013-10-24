package ocanalyzer.test;

import junit.framework.Test;
import junit.framework.TestSuite;
import ocanalyzer.test.integration.IntegrationTestElse;
import ocanalyzer.test.integration.IntegrationTestIndentation;

/**
 * This integration test is a bundle of all integration tests, testing the
 * correct validation of the Object Calisthenics Rules.
 * 
 * It sets up a test suite running all available integration tests. These tests
 * are in the package "ocanalyzer.test.integration".
 * 
 * @author Fabian Schwarz-Fritz
 * 
 */
public class OCExampleIntegrationTest {

	public static Test suite() {
		TestSuite suite = new TestSuite("org.ocanalyzer.integration");
		suite.addTestSuite(IntegrationTestElse.class);
		suite.addTestSuite(IntegrationTestIndentation.class);
		return suite;
	}
}
