package test.integration;

import java.util.List;

import junit.framework.TestCase;
import ocanalyzer.extractor.impl.ExtractorFactory;
import ocanalyzer.handlers.ElseHandlerMock;
import ocanalyzer.newIntegration.MockAnalyzerFactory;
import ocanalyzer.newIntegration.ClassTestReporter;
import ocanalyzer.reporter.ClassViolation;

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
		ClassTestReporter testReporter = new ClassTestReporter();
		ExtractorFactory factory = new MockAnalyzerFactory("elseRule");
		ElseHandlerMock ocMock = new ElseHandlerMock(
				factory, testReporter);

		ocMock.execute(null);

		List<ClassViolation> violations = testReporter.getViolations();

		assertSame(1, violations.size());
		ClassViolation violation = violations.get(0);
		assertEquals("Error when validating no-else rule. Wrong resource",
				"ElseWrong.java", violation.getResource().getName());
		assertEquals("Error when validating no-else rule. Wring position",
				new Integer(8), violation.getLine());
		assertEquals("Error when validating no-else rule. Wring message",
				"The else keyword violates rule 2", violation.getMessage());

	}
}
