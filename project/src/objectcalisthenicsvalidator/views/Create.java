/**
 * 
 */
package objectcalisthenicsvalidator.views;

import objectcalisthenicsvalidator.views.actions.OpenViolation;
import objectcalisthenicsvalidator.views.actions.StartRuleValidation;
import objectcalisthenicsvalidator.views.column.TableColumns;
import objectcalisthenicsvalidator.views.search.SearchAdapter;
import objectcalisthenicsvalidator.views.search.ViolationFilter;
import objectcalisthenicsvalidator.views.table.AddSortAction;
import objectcalisthenicsvalidator.views.table.ViolationProvider;
import ocanalyzer.ObjectCalisthenics;
import ocanalyzer.reporter.impl.ConsoleReporter;
import ocanalyzer.reporter.impl.DelegateReporter;
import ocanalyzer.reporter.impl.MarkerReporter;

import org.eclipse.jface.action.Action;
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

	public static void filter(Composite parent, final TableViewer viewer,
			final ViolationFilter filter) {
		createSearchText(parent, viewer, filter);
		createLabel(parent);
	}

	private static Label createLabel(Composite parent) {
		Label label = new Label(parent, SWT.NONE);
		label.setText("Search: ");
		return label;
	}

	private static Text createSearchText(Composite parent, final TableViewer viewer,
			final ViolationFilter filter) {
		Text text = new Text(parent, SWT.BORDER | SWT.SEARCH);
		text.setLayoutData(new GridData(GridData.GRAB_HORIZONTAL
				| GridData.HORIZONTAL_ALIGN_FILL));
		text.addKeyListener(new SearchAdapter(viewer, filter, text));
		return text;
	}

	public static Action startAction(ObjectCalisthenics oc,
			ViolationProvider tableProvider, TableViewer rulesViewer) {
		return new StartRuleValidation(oc, tableProvider, rulesViewer);
	}

	public static Action openAction(TableViewer rulesViewer) {
		return new OpenViolation(rulesViewer);
	}

}
