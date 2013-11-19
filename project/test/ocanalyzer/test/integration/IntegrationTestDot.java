package ocanalyzer.test.integration;

import java.util.List;

import junit.framework.TestCase;
import ocanalyzer.analyzer.AnalyzerFactory;
import ocanalyzer.reporter.Violation;
import ocanalyzer.test.integration.mock.MockAnalyzerFactory;
import ocanalyzer.test.integration.mock.TestReporter;
import ocanalyzer.test.integration.mock.dotRule.DotObjectCalisthenicsHandlerMock;

import org.eclipse.core.commands.ExecutionException;

public class IntegrationTestDot extends TestCase {

	public void testDotRule() throws ExecutionException {
		TestReporter testReporter = new TestReporter();
		AnalyzerFactory factory = new MockAnalyzerFactory("dotRule");
		DotObjectCalisthenicsHandlerMock ocMock = new DotObjectCalisthenicsHandlerMock(
				factory, testReporter);

		ocMock.execute(null);

		List<Violation> violations = testReporter.getViolations();

		assertSame(2, violations.size());

		Violation violation1 = violations.get(0);
		assertEquals("Error when validating dot rule. Wrong resource",
				"DotWrong.java", violation1.getResource().getName());
		assertEquals("Error when validating dot rule. Wrong position",
				new Integer(9), violation1.getLine());
		assertEquals("Error when validating dot rule. Wrong message",
				"??? Use only one dot per line!", violation1.getMessage());

		Violation violation2 = violations.get(1);
		assertEquals("Error when validating dot rule. Wrong resource",
				"DotWrong.java", violation2.getResource().getName());
		assertEquals("Error when validating dot rule. Wrong position",
				new Integer(10), violation2.getLine());
		assertEquals("Error when validating dot rule. Wrong message",
				"??? Use only one dot per line!", violation2.getMessage());

	}
}
