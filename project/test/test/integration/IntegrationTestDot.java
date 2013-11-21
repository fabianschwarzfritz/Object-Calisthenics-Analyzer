package test.integration;

import java.util.List;

import junit.framework.TestCase;
import ocanalyzer.analyzer.factory.ExtractorFactory;
import ocanalyzer.analyzer.factory.MockAnalyzerFactory;
import ocanalyzer.analyzer.reporter.TestReporter;
import ocanalyzer.handlers.DotHandlerMock;
import ocanalyzer.reporter.ClassViolation;

import org.eclipse.core.commands.ExecutionException;

public class IntegrationTestDot extends TestCase {

	public void testDotRule() throws ExecutionException {
		TestReporter testReporter = new TestReporter();
		ExtractorFactory factory = new MockAnalyzerFactory("dotRule");
		DotHandlerMock ocMock = new DotHandlerMock(factory, testReporter);

		ocMock.execute(null);

		List<ClassViolation> violations = testReporter.getViolations();

		assertSame(2, violations.size());

		ClassViolation violation1 = violations.get(0);
		assertEquals("Error when validating dot rule. Wrong resource",
				"DotWrong.java", violation1.getResource().getName());
		assertEquals("Error when validating dot rule. Wrong position",
				new Integer(9), violation1.getLine());
		assertEquals("Error when validating dot rule. Wrong message",
				"Using more that one dot per line violates rule 4!",
				violation1.getMessage());

		ClassViolation violation2 = violations.get(1);
		assertEquals("Error when validating dot rule. Wrong resource",
				"DotWrong.java", violation2.getResource().getName());
		assertEquals("Error when validating dot rule. Wrong position",
				new Integer(10), violation2.getLine());
		assertEquals("Error when validating dot rule. Wrong message",
				"Using more that one dot per line violates rule 4!", violation2.getMessage());

	}
}
