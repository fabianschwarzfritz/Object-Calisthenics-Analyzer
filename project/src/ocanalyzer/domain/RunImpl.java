package ocanalyzer.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import ocanalyzer.extractor.Extractor;
import ocanalyzer.extractor.impl.ExtractorImpl;
import ocanalyzer.reporter.TrainingReporter;
import ocanalyzer.rules.general.ICompilationUnits;
import ocanalyzer.rules.impl.OCRulesImpl;

public class RunImpl implements Run {

	private RunImpl previous;
	private RunImpl next;

	private Date time;
	private List<Violation> violations;

	private Extractor extractor;
	private TrainingReporter trainingReporter;

	RunImpl() {
		previous = this;
		init();
	}

	RunImpl(RunImpl previous) {
		this.previous = previous;
		init();
	}

	private void init() {
		violations = new ArrayList<Violation>();
		time = new Date();
		extractor = new ExtractorImpl();
	}

	public Run update() {
		RunImpl newRun = new RunImpl(this);
		trainingReporter = new TrainingReporter(newRun);
		this.next = newRun;
		newRun.previous = this;
		return newRun;
	}

	public int countViolations() {
		return violations.size();
	}

	public void addViolation(Violation violation) {
		violations.add(violation);
	}

	public void validate() {
		OCRulesImpl rules = OCRulesImpl.createStandardRules(trainingReporter);
		ICompilationUnits units = extractor.extract();
		rules.apply(units);
	}
}
