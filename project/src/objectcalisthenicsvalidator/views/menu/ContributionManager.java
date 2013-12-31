/**
 * 
 */
package objectcalisthenicsvalidator.views.menu;

import objectcalisthenicsvalidator.views.actions.Actions;

import org.eclipse.jface.action.IContributionManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.ui.IWorkbenchActionConstants;

/**
 * @author Fabian Schwarz-Fritz
 * 
 */
public class ContributionManager {

	private IContributionManager contribution;

	public ContributionManager(IContributionManager contribution) {
		this.contribution = contribution;
	}

	public void addActions(Actions actions) {
		actions.addTo(contribution);
		contribution.add(new Separator(IWorkbenchActionConstants.MB_ADDITIONS));
	}

}
