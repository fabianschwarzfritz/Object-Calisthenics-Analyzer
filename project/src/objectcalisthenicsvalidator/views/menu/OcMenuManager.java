/**
 * 
 */
package objectcalisthenicsvalidator.views.menu;

import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;

/**
 * @author Fabian Schwarz-Fritz
 * 
 */
public class OcMenuManager extends MenuManager implements IMenuListener {

	private ContributionManager contribution;
	private Actions actions;
	

	public OcMenuManager(Actions actions) {
		super("#PopupMenu");
		this.actions = actions;
		contribution = new ContributionManager(this);
		setRemoveAllWhenShown(true);
	}

	@Override
	public void menuAboutToShow(IMenuManager manager) {
		contribution.addActions(actions);
	}

}