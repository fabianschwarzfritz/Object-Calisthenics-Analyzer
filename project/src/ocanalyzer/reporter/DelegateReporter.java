package ocanalyzer.reporter;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IResource;

/**
 * This class reports all errors to all given reporters in the package.
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
