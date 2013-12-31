package objectcalisthenicsvalidator.views;

import objectcalisthenicsvalidator.views.actions.Actions;
import objectcalisthenicsvalidator.views.actions.AnalyzeActions;
import objectcalisthenicsvalidator.views.menu.OcMenu;
import objectcalisthenicsvalidator.views.menu.OcToolbar;
import objectcalisthenicsvalidator.views.table.ViolationProvider;
import objectcalisthenicsvalidator.views.table.ViolationTable;
import ocanalyzer.ObjectCalisthenics;
import ocanalyzer.reporter.impl.DelegateReporter;

import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.ViewPart;

/**
 * This class represents the main view displaying information about rule
 * violations in the Object Calisthenics.
 * 
 * @author Fabian Schwarz-Fritz
 * 
 */

public class ObjectCalisthenicsView extends ViewPart {

	public static final String ID = "objectcalisthenicsvalidator.views.ObjectCalisthenicsView";

	private ObjectCalisthenics oc;
	private ViolationProvider tableProvider;

	private ViolationTable table;
	private OcMenu menu;
	private OcToolbar toolbar;

	private Actions analyzeActions;

	public ObjectCalisthenicsView() {
		tableProvider = new ViolationProvider();
		DelegateReporter reporter = Create.reporter(tableProvider);
		oc = ObjectCalisthenics.create(reporter);
	}

	@Override
	public void createPartControl(Composite parent) {
		GridLayout layout = new GridLayout(1, true);
		parent.setLayout(layout);

		table = new ViolationTable(parent, tableProvider, getViewSite());
		analyzeActions = new AnalyzeActions(oc, tableProvider, table);
		menu = new OcMenu(table, getSite(), analyzeActions);
		toolbar = new OcToolbar(getViewSite(), analyzeActions);
	}

	@Override
	public void setFocus() {
		table.getControl().setFocus();
	}
}
