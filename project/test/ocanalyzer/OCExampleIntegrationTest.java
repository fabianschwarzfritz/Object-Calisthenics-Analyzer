package ocanalyzer;

import junit.framework.Test;
import junit.framework.TestSuite;
import test.integration.IntegrationTestDot;
import test.integration.IntegrationTestElse;
import test.integration.IntegrationTestIndentation;
import test.integration.IntegrationTestWrapPrimitivesAndStrings;

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
		suite.addTestSuite(IntegrationTestDot.class);
		suite.addTestSuite(IntegrationTestElse.class);
		suite.addTestSuite(IntegrationTestIndentation.class);
		suite.addTestSuite(IntegrationTestWrapPrimitivesAndStrings.class);
		return suite;
	}
}
