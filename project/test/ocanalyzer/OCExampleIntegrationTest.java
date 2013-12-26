package ocanalyzer;

import ocanalyzer.integration.DotIntegration;
import ocanalyzer.integration.ElseIntegration;
import ocanalyzer.integration.IndentationIntegration;
import ocanalyzer.integration.WrapPrimitivesIntegration;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

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

@RunWith(Suite.class)
@Suite.SuiteClasses({ DotIntegration.class, ElseIntegration.class,
		IndentationIntegration.class, WrapPrimitivesIntegration.class })
public class OCExampleIntegrationTest {

}
