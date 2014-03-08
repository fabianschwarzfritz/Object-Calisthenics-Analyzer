package ocanalyzer.domain;

import java.util.ArrayList;
import java.util.List;

public class Run {

	private Run previous;
	private Run next;
	private List<Violation> violations;

	Run() {
		previous = this;
	}
	
	Run(Run previous) {
		this.previous = previous;
		violations = new ArrayList<Violation>();
	}

	public Run update() {
		Run newRun = new Run(this);
		this.next = newRun;
		newRun.previous = this;
		return newRun;
	}

	private int countViolations() {
		// TODO implement method
		return 0;
	}
}
