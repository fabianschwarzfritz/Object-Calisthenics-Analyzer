package ocanalyzer.domain;

public class Training {

	private Project project;
	private Run lastRun;

	public Training(Project project) {
		this.project = project;
		lastRun = new RunImpl();
	}

	public Run create() {
		Run update = lastRun.update();
		lastRun = update;
		return update;
	}

}
