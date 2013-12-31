/**
 * 
 */
package objectcalisthenicsvalidator.views;

import objectcalisthenicsvalidator.views.column.TableColumns;
import objectcalisthenicsvalidator.views.search.SearchAdapter;
import objectcalisthenicsvalidator.views.search.ViolationFilter;
import objectcalisthenicsvalidator.views.table.AddSortAction;
import objectcalisthenicsvalidator.views.table.ViolationProvider;
import ocanalyzer.reporter.impl.ConsoleReporter;
import ocanalyzer.reporter.impl.DelegateReporter;
import ocanalyzer.reporter.impl.MarkerReporter;

import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

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

	public static void sorting(TableViewer viewer, TableColumns columns) {
		columns.each(new AddSortAction(viewer));
	}

}
