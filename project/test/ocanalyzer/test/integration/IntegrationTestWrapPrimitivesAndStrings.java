package ocanalyzer.test.integration;

import java.util.List;

import junit.framework.TestCase;
import ocanalyzer.analyzer.AnalyzerFactory;
import ocanalyzer.reporter.Violation;
import ocanalyzer.test.integration.mock.MockAnalyzerFactory;
import ocanalyzer.test.integration.mock.TestReporter;
import ocanalyzer.test.integration.wrapPrimitivesAndStrings.WrapPrimitivesObjectCalisthenicsHandlerMock;

import org.eclipse.core.commands.ExecutionException;

public class IntegrationTestWrapPrimitivesAndStrings extends TestCase {

	public void testWrapperClassesDatabase() throws ExecutionException {
		TestReporter testReporter = new TestReporter();
		AnalyzerFactory factory = new MockAnalyzerFactory(
				"wrapPrimitives_wrong_db");
		WrapPrimitivesObjectCalisthenicsHandlerMock ocMock = new WrapPrimitivesObjectCalisthenicsHandlerMock(
				factory, testReporter);

		ocMock.execute(null);

		List<Violation> violations = testReporter.getViolations();

		assertSame(1, violations.size());
		Violation violation = violations.get(0);
		assertEquals(
				"Error finding a primitive/string wrapper. Wrong resource",
				"DBConfiguration.java", violation.getResource().getName());
		assertEquals(
				"Error finding a primitive/string wrapper. Wrong position",
				new Integer(3), violation.getLine());

	}

}
