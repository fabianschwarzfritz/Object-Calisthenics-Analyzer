/**
 * 
 */
package objectcalisthenicsvalidator.views.actions;

import objectcalisthenicsvalidator.views.table.ViolationProvider;
import ocanalyzer.ObjectCalisthenics;

import org.eclipse.jface.viewers.TableViewer;

/**
 * @author Fabian Schwarz-Fritz
 * 
 */
public class Analyze extends Actions {

	public Analyze(ObjectCalisthenics oc, ViolationProvider tableProvider,
			TableViewer table) {
		super();
		StartRuleValidation startRuleValidation = new StartRuleValidation(oc,
				tableProvider, table);
		ClearMarker clearMarker = new ClearMarker();
		add(startRuleValidation);
		add(clearMarker);
	}

}
