package ocanalyzer.domain;

import java.util.ArrayList;
import java.util.List;

public class RunImpl implements Run {

	private RunImpl previous;
	private RunImpl next;
	private List<Violation> violations;

	RunImpl() {
		previous = this;
	}

	RunImpl(RunImpl previous) {
		this.previous = previous;
		violations = new ArrayList<Violation>();
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
}
