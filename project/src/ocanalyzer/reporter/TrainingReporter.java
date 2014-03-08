package ocanalyzer.reporter;

import ocanalyzer.domain.Run;
import ocanalyzer.domain.ViolationImpl;

public class TrainingReporter implements Reporter {

	private Run run;

	public TrainingReporter(Run run) {
		this.run = run;
	}

	@Override
	public void reportError(ViolationImpl violation) {
		run.addViolation(violation);
	}

}
