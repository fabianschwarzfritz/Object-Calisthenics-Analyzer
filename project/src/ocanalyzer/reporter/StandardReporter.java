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
public class StandardReporter implements RuleViolationReporter {

	private List<RuleViolationReporter> reporters;

	public StandardReporter() {
		reporters = new ArrayList<RuleViolationReporter>();
		reporters.add(new ConsoleReporter(System.out));
		reporters.add(new MarkerReporter());
	}

	@Override
	public void reportError(IResource resource, int line, String msg) {
		for (RuleViolationReporter reporter : reporters) {
			reporter.reportError(resource, line, msg);
		}
	}

}
