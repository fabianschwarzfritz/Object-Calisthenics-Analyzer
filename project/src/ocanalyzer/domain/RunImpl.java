package ocanalyzer.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RunImpl implements Run {

	private RunImpl previous;
	private RunImpl next;
	private Date time;
	private List<Violation> violations;

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
	}

	public Run update() {
		RunImpl newRun = new RunImpl(this);
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
}
