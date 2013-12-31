/**
 * 
 */
package objectcalisthenicsvalidator.views.menu;

import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.ui.IWorkbenchPartSite;

/**
 * @author Fabian Schwarz-Fritz
 * 
 */
public class OcMenu {

	public OcMenu(Viewer viewer, IWorkbenchPartSite site, Actions actions) {
		super();
		OcMenuManager menuManager = new OcMenuManager(actions);

		Control control = viewer.getControl();
		Menu menu = menuManager.createContextMenu(control);
		control.setMenu(menu);
		site.registerContextMenu(menuManager, viewer);
	}
}
