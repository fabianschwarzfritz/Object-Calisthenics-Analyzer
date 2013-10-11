package ocanalyzer.test.integration.mock;

import ocanalyzer.handlers.ObjectCalisthenicsHandler;

public class WorkspaceHandlerMock extends ObjectCalisthenicsHandler {

	public WorkspaceHandlerMock(TestAnalyzerMock analyzerMock) {
		factory = new AnalyzerFactoryTest(analyzerMock);
	}

}
