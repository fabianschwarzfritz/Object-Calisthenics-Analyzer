package ocanalyzer.domain;

import ocanalyzer.reporter.TrainingReporter;

public class Training {

	private Project project;
	private Run lastRun;
	private TrainingReporter trainingReporter;

	public Training(Project project) {
		this.project = project;
		lastRun = new RunImpl();
	}

	public Run create() {
		Run update = lastRun.update();
		trainingReporter = new TrainingReporter(update);
		lastRun = update;
		return update;
	}

}
