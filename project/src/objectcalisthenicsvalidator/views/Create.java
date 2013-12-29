/**
 * 
 */
package objectcalisthenicsvalidator.views;

import objectcalisthenicsvalidator.views.actions.OpenViolation;
import objectcalisthenicsvalidator.views.actions.StartRuleValidation;
import objectcalisthenicsvalidator.views.table.ValidationSorter;
import objectcalisthenicsvalidator.views.table.ViolationProvider;
import ocanalyzer.ObjectCalisthenics;
import ocanalyzer.reporter.impl.ConsoleReporter;
import ocanalyzer.reporter.impl.DelegateReporter;
import ocanalyzer.reporter.impl.MarkerReporter;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;

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

	public static void sorting(TableViewer viewer, TableColumn... columns) {
		Table table = viewer.getTable();
		ValidationSorter validationSorter = new ValidationSorter(table);
		viewer.setSorter(validationSorter);
		for (int i = 0; i < columns.length; i++) {
			TableColumn tableColumn = columns[i];
			addSort(viewer, tableColumn, i);
		}
	}

	public static Action startAction(ObjectCalisthenics oc,
			ViolationProvider tableProvider, TableViewer rulesViewer) {
		return new StartRuleValidation(oc, tableProvider, rulesViewer);
	}

	public static Action openAction(TableViewer rulesViewer) {
		return new OpenViolation(rulesViewer);
	}

	private static void addSort(final TableViewer viewer,
			final TableColumn column, final int sort) {
		column.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent event) {
				Table table = viewer.getTable();
				table.setSortColumn(column);
				ValidationSorter sorter = (ValidationSorter) viewer.getSorter();
				sorter.doSort(sort);
				sorter.adjustArrow();
				viewer.refresh();
			}
		});
	}

}
