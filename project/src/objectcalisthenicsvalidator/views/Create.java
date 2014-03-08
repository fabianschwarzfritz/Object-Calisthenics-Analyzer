/**
 * 
 */
package objectcalisthenicsvalidator.views;

import objectcalisthenicsvalidator.views.table.ViolationProvider;
import ocanalyzer.reporter.impl.ConsoleReporter;
import ocanalyzer.reporter.impl.DelegateReporter;
import ocanalyzer.reporter.impl.MarkerReporter;

/**
 * @author Fabian Schwarz-Fritz
 * 
 */
public class Create {

	public static DelegateReporter reporter(ViolationProvider... providers) {
		DelegateReporter reporter = new DelegateReporter();
		reporter.addReporter(new MarkerReporter());
		reporter.addReporter(new ConsoleReporter(System.out));
		for (ViolationProvider violationProvider : providers) {
			reporter.addReporter(violationProvider);
		}
		return reporter;
	}

}
