package ocanalyzer.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import ocanalyzer.reporter.Reporter;
import ocanalyzer.reporter.TrainingReporter;
import ocanalyzer.reporter.impl.DelegateReporter;
import ocanalyzer.rules.general.ICompilationUnits;
import ocanalyzer.rules.impl.OCRulesImpl;

public class RunImpl implements Run {

	private RunImpl previous;
	private RunImpl next;

	private Date time;
	private List<Violation> violations;

	private Project project;
	private TrainingReporter trainingReporter;

	RunImpl(Project project) {
		previous = this;
		this.project = project;
		init();
	}

	RunImpl(RunImpl previous, Project project) {
		this.project = project;
		this.previous = previous;
		init();
	}

	private void init() {
		violations = new ArrayList<Violation>();
		time = new Date();
	}

	public RunImpl update() {
		RunImpl newRun = new RunImpl(this, project);
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

	public void validate(Reporter reporter) {
		DelegateReporter delegate = new DelegateReporter();
		delegate.addReporter(reporter);
		delegate.addReporter(trainingReporter);

		OCRulesImpl rules = OCRulesImpl.createStandardRules(delegate);
		ICompilationUnits units = project.changedUnits();
		rules.apply(units);
	}
}
