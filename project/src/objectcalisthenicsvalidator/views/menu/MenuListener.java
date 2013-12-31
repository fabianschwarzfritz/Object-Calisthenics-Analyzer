/**
 * 
 */
package objectcalisthenicsvalidator.views.menu;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;

/**
 * @author Fabian Schwarz-Fritz
 * 
 */
public class MenuListener implements IMenuListener {

	private Action action;

	public MenuListener(Action action) {
		super();
		this.action = action;
	}

	@Override
	public void menuAboutToShow(IMenuManager manager) {
		manager.add(action);
	}
}
