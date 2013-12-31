/**
 * 
 */
package objectcalisthenicsvalidator.views.menu;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IContributionManager;

/**
 * @author Fabian Schwarz-Fritz
 * 
 */
public class Actions {

	private List<Action> actions;

	public Actions() {
		actions = new ArrayList<>();
	}

	public void add(Action action) {
		actions.add(action);
	}

	public void addTo(IContributionManager manager) {
		for (Action action : actions) {
			manager.add(action);
		}
	}

}
