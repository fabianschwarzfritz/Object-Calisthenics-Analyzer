package ocanalyzer.test.integration.mock;

import ocanalyzer.handlers.ObjectCalisthenicsHandler;
import ocanalyzer.reporter.RuleViolationReporter;

public class WorkspaceHandlerMock extends ObjectCalisthenicsHandler {

	public WorkspaceHandlerMock(RuleViolationReporter testReporter) {
		factory = new AnalyzerFactoryTest(testReporter);
	}

}
