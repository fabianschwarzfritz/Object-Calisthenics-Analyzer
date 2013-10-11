package ocanalyzer.test.integration;

import java.util.List;

import junit.framework.TestCase;
import ocanalyzer.helper.Triple;
import ocanalyzer.test.integration.mock.TestReporter;
import ocanalyzer.test.integration.mock.WorkspaceHandlerMock;
import ocanalyzer.test.integration.mock.indentiationRule.TestAnalyzerIndentiationRuleMock;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IResource;

public class IntegrationTestIndentiation extends TestCase {

	public void testIntendiation() throws ExecutionException {
		TestReporter testReporter = new TestReporter();
		TestAnalyzerIndentiationRuleMock analyzerMock = new TestAnalyzerIndentiationRuleMock(
				testReporter);
		WorkspaceHandlerMock mockWorkspaceHandler = new WorkspaceHandlerMock(
				analyzerMock);

		mockWorkspaceHandler.execute(null);

		List<Triple<IResource, Integer, String>> violations = testReporter
				.getViolations();

		assertSame(1, violations.size());
		Triple<IResource, Integer, String> triple = violations.get(0);
		IResource resource = triple.getA();
		Integer position = triple.getB();
		String message = triple.getC();
		assertEquals("Error when validating intentiation rule. Wrong resource",
				resource.getName(), "Intentiation.java");
		assertEquals("Error when validating intentiation rule. Wring position",
				new Integer(7), new Integer(position));
		assertEquals("Error when validating intentiation rule. Wring message",
				"The else keyword violates rule 1", message);
	}

}
