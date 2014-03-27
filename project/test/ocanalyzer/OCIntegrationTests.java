package ocanalyzer;

import ocanalyzer.rules.r1_indentation.IndentationTest;
import ocanalyzer.rules.r2_noelse.ElseTest;
import ocanalyzer.rules.r4_onedot.DotTest;
import ocanalyzer.rules.r7_instanceVariable.InstanceTest;
import ocanalyzer.rules.r9_properties.PropertiesTest;

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
@Suite.SuiteClasses({ ElseTest.class, IndentationTest.class, DotTest.class,
		InstanceTest.class, PropertiesTest.class })
public class OCIntegrationTests {

}
