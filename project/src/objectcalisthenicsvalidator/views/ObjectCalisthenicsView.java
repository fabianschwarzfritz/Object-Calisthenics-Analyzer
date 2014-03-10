package objectcalisthenicsvalidator.views;

import objectcalisthenicsvalidator.views.actions.Actions;
import objectcalisthenicsvalidator.views.actions.Analyze;
import objectcalisthenicsvalidator.views.menu.OcMenu;
import objectcalisthenicsvalidator.views.menu.OcToolbar;
import objectcalisthenicsvalidator.views.search.SearchComposite;
import objectcalisthenicsvalidator.views.search.ViolationFilter;
import objectcalisthenicsvalidator.views.table.ViolationProvider;
import objectcalisthenicsvalidator.views.table.ViolationTable;
import ocanalyzer.domain.Training;

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

	private Training training;
	private ViolationProvider tableModel;

	private SearchComposite search;
	private ViolationTable table;
	private OcMenu menu;
	private OcToolbar toolbar;

	private Actions analyzeActions;

	public ObjectCalisthenicsView() {
		tableModel = new ViolationProvider();
		training = new Training();
	}

	@Override
	public void createPartControl(Composite parent) {
		ViolationFilter filter = new ViolationFilter();

		parent.setLayout(new GridLayout());

		search = new SearchComposite(parent);

		table = new ViolationTable(parent, tableModel, getViewSite());
		table.addFilter(filter);

		tableModel.setTable(table);

		search.setResultComposite(table, filter);

		analyzeActions = new Analyze(training, tableModel);
		menu = new OcMenu(table, getSite(), analyzeActions);
		toolbar = new OcToolbar(getViewSite(), analyzeActions);
	}

	@Override
	public void setFocus() {
		table.getControl().setFocus();
	}
}
