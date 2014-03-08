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

	RunImpl(RunImpl previous, Project project, TrainingReporter reporter) {
		this.project = project;
		this.previous = previous;
		this.trainingReporter = reporter;
		init();
	}

	private void init() {
		violations = new ArrayList<Violation>();
		time = new Date();
	}

	public RunImpl update() {
		RunImpl newRun = createNewRun();
		updateReferences(newRun);
		return newRun;
	}

	private RunImpl createNewRun() {
		RunImpl newRun = null;
		TrainingReporter newReporter = new TrainingReporter(newRun);
		newRun = new RunImpl(this, project, newReporter);
		return newRun;
	}

	private void updateReferences(RunImpl newRun) {
		this.next = newRun;
		newRun.previous = this;
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
