package ocanalyzer.test.integration;

import java.util.List;

import junit.framework.TestCase;
import ocanalyzer.helper.Triple;
import ocanalyzer.test.integration.mock.TestReporter;
import ocanalyzer.test.integration.mock.WorkspaceHandlerMock;
import ocanalyzer.test.integration.mock.elseRule.TestAnalyzerElseRuleMock;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IResource;

/**
 * Integration test testing correct validation of rule 2: no else.
 * 
 * Each test is coupled to a java class that is to validate.
 * 
 * @author Fabian Schwarz-Fritz
 * 
 */
public class IntegrationTestElse extends TestCase {

	public void testElseRule() throws ExecutionException {
		TestReporter testReporter = new TestReporter();
		TestAnalyzerElseRuleMock analyzerMock = new TestAnalyzerElseRuleMock(
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
		assertEquals("Error when validating no-else rule. Wrong resource",
				resource.getName(), "Else.java");
		assertEquals("Error when validating no-else rule. Wring position",
				new Integer(6), new Integer(position));
		assertEquals("Error when validating no-else rule. Wring message",
				"The else keyword violates rule 2", message);

	}
}
