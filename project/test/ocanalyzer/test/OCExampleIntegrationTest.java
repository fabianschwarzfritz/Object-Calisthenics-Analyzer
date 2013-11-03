package ocanalyzer.test;

import junit.framework.Test;
import junit.framework.TestSuite;
import ocanalyzer.test.integration.IntegrationTestElse;
import ocanalyzer.test.integration.IntegrationTestIndentation;
import ocanalyzer.test.integration.IntegrationTestWrapPrimitivesAndStrings;

/**
 * This integration test is a bundle of all integration tests, testing the
 * correct validation of the Object Calisthenics Rules.
 * 
 * It sets up a test suite running all available integration tests. These tests
 * are in the package "ocanalyzer.test.integration".
 * 
 * The classes that are used for the integration test are located in the
 * corresponding rule package of the test project
 * 
 * @author Fabian Schwarz-Fritz
 * 
 */
public class OCExampleIntegrationTest {

	public static Test suite() {
		TestSuite suite = new TestSuite("org.ocanalyzer.integration");
		suite.addTestSuite(IntegrationTestElse.class);
		suite.addTestSuite(IntegrationTestIndentation.class);
		suite.addTestSuite(IntegrationTestWrapPrimitivesAndStrings.class);
		return suite;
	}
}
