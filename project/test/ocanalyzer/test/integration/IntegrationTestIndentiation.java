package ocanalyzer.test.integration;

import java.util.List;

import junit.framework.TestCase;
import ocanalyzer.analyzer.AnalyzerFactory;
import ocanalyzer.helper.Triple;
import ocanalyzer.test.integration.mock.TestReporter;
import ocanalyzer.test.integration.mock.indentiationRule.IndentationTestAnalyzerFactory;
import ocanalyzer.test.integration.mock.indentiationRule.IndentiationObjectCalisthenicsHandlerMock;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IResource;

public class IntegrationTestIndentiation extends TestCase {

	public void testIntendiation() throws ExecutionException {
		TestReporter testReporter = new TestReporter();
		AnalyzerFactory factory = new IndentationTestAnalyzerFactory();
		IndentiationObjectCalisthenicsHandlerMock ocMock = new IndentiationObjectCalisthenicsHandlerMock(
				factory, testReporter);

		ocMock.execute(null);

		List<Triple<IResource, Integer, String>> violations = testReporter
				.getViolations();

		assertSame(1, violations.size());
		Triple<IResource, Integer, String> triple = violations.get(0);
		IResource resource = triple.getA();
		Integer position = triple.getB();
		String message = triple.getC();
		assertEquals("Error when validating intentiation rule. Wrong resource",
				"IndentationWrong.java", resource.getName());
		assertEquals("Error when validating intentiation rule. Wring position",
				new Integer(7), new Integer(position));
		assertEquals("Error when validating intentiation rule. Wring message",
				"The else keyword violates rule 1", message);
	}

}
