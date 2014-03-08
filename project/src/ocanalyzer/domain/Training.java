package ocanalyzer.domain;

public class Training {

	private Run lastRun;

	public Training() {
		lastRun = new RunImpl();
	}

	public Run create() {
		Run update = lastRun.update();
		lastRun = update;
		return update;
	}

}
