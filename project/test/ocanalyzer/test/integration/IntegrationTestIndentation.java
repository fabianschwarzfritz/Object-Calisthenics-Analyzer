package ocanalyzer.test.integration;

import java.util.List;

import junit.framework.TestCase;
import ocanalyzer.analyzer.AnalyzerFactory;
import ocanalyzer.handlers.ObjectCalisthenicsHandler;
import ocanalyzer.reporter.Violation;
import ocanalyzer.test.integration.mock.TestReporter;
import ocanalyzer.test.integration.mock.indentationRule.IndentationTestAnalyzerFactory;

import org.eclipse.core.commands.ExecutionException;

/**
 * Integration test testing correct validation of rule 1: one indentation per
 * method.
 * 
 * {@see OCExampleIntegrationTest}, the test suite startin gthe integraiton test
 * 
 * @author Fabian Schwarz-Fritz
 * 
 */
public class IntegrationTestIndentation extends TestCase {

	public void testIntendiation() throws ExecutionException {
		TestReporter testReporter = new TestReporter();
		AnalyzerFactory factory = new IndentationTestAnalyzerFactory();
		ObjectCalisthenicsHandler oc = new ObjectCalisthenicsHandler(factory,
				testReporter);

		oc.execute(null);

		List<Violation> violations = testReporter.getViolations();

		assertSame(1, violations.size());
		Violation violation = violations.get(0);
		assertEquals("Error when validating indentation rule. Wrong resource",
				"IndentationWrong.java", violation.getResource().getName());
		assertEquals("Error when validating indentation rule. Wring position",
				new Integer(7), violation.getLine());
		assertEquals("Error when validating indentation rule. Wring message",
				"The given indentation violates rule 1", violation.getMessage());
	}

}
