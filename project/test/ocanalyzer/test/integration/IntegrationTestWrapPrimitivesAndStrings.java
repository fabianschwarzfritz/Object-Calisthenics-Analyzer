package ocanalyzer.test.integration;

import java.util.List;

import junit.framework.TestCase;
import ocanalyzer.analyzer.AnalyzerFactory;
import ocanalyzer.reporter.Violation;
import ocanalyzer.test.integration.mock.TestReporter;
import ocanalyzer.test.integration.wrapPrimitivesAndStrings.WrapPrimitivesAnalyzerFactory;
import ocanalyzer.test.integration.wrapPrimitivesAndStrings.WrapPrimitivesObjectCalisthenicsHandlerMock;

import org.eclipse.core.commands.ExecutionException;

public class IntegrationTestWrapPrimitivesAndStrings extends TestCase {

	public void testIntendiation() throws ExecutionException {
		TestReporter testReporter = new TestReporter();
		AnalyzerFactory factory = new WrapPrimitivesAnalyzerFactory();
		WrapPrimitivesObjectCalisthenicsHandlerMock ocMock = new WrapPrimitivesObjectCalisthenicsHandlerMock(
				factory, testReporter);

		ocMock.execute(null);

		List<Violation> violations = testReporter.getViolations();

		/*
		 * assertSame(1, violations.size()); Violation violation =
		 * violations.get(0);
		 * assertEquals("Error when validating indentation rule. Wrong resource"
		 * , "IndentationWrong.java", violation.getResource().getName());
		 * assertEquals
		 * ("Error when validating indentation rule. Wring position", new
		 * Integer(7), violation.getLine());
		 * assertEquals("Error when validating indentation rule. Wring message",
		 * "The given indentation violates rule 1", violation.getMessage());
		 */
	}

}
