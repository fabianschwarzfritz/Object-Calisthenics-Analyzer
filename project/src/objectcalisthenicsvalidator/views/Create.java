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
		reporter.addClassReporter(new MarkerReporter());
		reporter.addClassReporter(new ConsoleReporter(System.out));
		reporter.addPackageReporter(new ConsoleReporter(System.out));
		for (ViolationProvider violationProvider : providers) {
			reporter.addClassReporter(violationProvider);
			reporter.addPackageReporter(violationProvider);
		}
		return reporter;
	}
}
