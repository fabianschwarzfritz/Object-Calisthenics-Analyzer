/**
 * 
 */
package objectcalisthenicsvalidator.views.menu;

import objectcalisthenicsvalidator.views.actions.Actions;

import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IViewSite;

/**
 * @author Fabian Schwarz-Fritz
 * 
 */
public class OcToolbar {

	private ContributionManager manager;
	private IToolBarManager toolBarManager;

	public OcToolbar(IViewSite site, Actions actions) {
		IActionBars bars = site.getActionBars();
		toolBarManager = bars.getToolBarManager();
		manager = new ContributionManager(toolBarManager);
		manager.addActions(actions);
	}

}
