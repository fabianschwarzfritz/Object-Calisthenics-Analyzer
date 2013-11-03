package ocanalyzer.test.integration;

import java.util.List;

import junit.framework.TestCase;
import ocanalyzer.analyzer.AnalyzerFactory;
import ocanalyzer.reporter.Violation;
import ocanalyzer.test.integration.mock.TestReporter;
import ocanalyzer.test.integration.mock.elseRule.ElseAnalyzerFactory;
import ocanalyzer.test.integration.mock.elseRule.ElseObjectCalisthenicsHandlerMock;

import org.eclipse.core.commands.ExecutionException;

/**
 * Integration test testing correct validation of rule 2: no else.
 * 
 * {@see OCExampleIntegrationTest}, the test suite startin gthe integraiton test
 * 
 * @author Fabian Schwarz-Fritz
 * 
 */
public class IntegrationTestElse extends TestCase {

	public void testElseRule() throws ExecutionException {
		TestReporter testReporter = new TestReporter();
		AnalyzerFactory factory = new ElseAnalyzerFactory();
		ElseObjectCalisthenicsHandlerMock ocMock = new ElseObjectCalisthenicsHandlerMock(
				factory, testReporter);

		ocMock.execute(null);

		List<Violation> violations = testReporter.getViolations();

		assertSame(1, violations.size());
		Violation violation = violations.get(0);
		assertEquals("Error when validating no-else rule. Wrong resource",
				"ElseWrong.java", violation.getResource().getName());
		assertEquals("Error when validating no-else rule. Wring position",
				new Integer(8), violation.getLine());
		assertEquals("Error when validating no-else rule. Wring message",
				"The else keyword violates rule 2", violation.getMessage());

	}
}
