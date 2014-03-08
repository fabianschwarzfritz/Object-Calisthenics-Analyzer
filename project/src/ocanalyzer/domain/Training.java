package ocanalyzer.domain;

import ocanalyzer.extractor.impl.ExtractorImpl;

public class Training {

	private Project project;
	private RunImpl lastRun;

	public Training() {
		// FIXME later the project has to be injected by the ui here
		project = new Project(new ExtractorImpl());
		lastRun = new RunImpl(project);
	}

	public Run create() {
		RunImpl update = lastRun.update();
		lastRun = update;
		return update;
	}

}
