package ocanalyzer.test.integration.mock;

import ocanalyzer.handlers.WorkspaceHandler;
import ocanalyzer.reporter.RuleViolationReporter;
import ocanalyzer.test.integration.AnalyzerFactoryTest;

public class WorkspaceHandlerMock extends WorkspaceHandler {

	public WorkspaceHandlerMock(RuleViolationReporter testReporter) {
		factory = new AnalyzerFactoryTest(testReporter);
	}

}
