package ocanalyzer.reporter;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IResource;

/**
 * This class is used to delegate a rule violation event to all given
 * {@link RuleViolationReporter}s in {@link reporters}.
 * 
 * @author Fabian Schwarz-Fritz
 * 
 */
public class DelegateReporter implements RuleViolationReporter {

	private List<RuleViolationReporter> reporters;

	public DelegateReporter() {
		reporters = new ArrayList<RuleViolationReporter>();
	}

	public void add(RuleViolationReporter reporter) {
		reporters.add(reporter);
	}

	@Override
	public void reportError(IResource resource, int line, String msg) {
		for (RuleViolationReporter reporter : reporters) {
			reporter.reportError(resource, line, msg);
		}
	}

}
