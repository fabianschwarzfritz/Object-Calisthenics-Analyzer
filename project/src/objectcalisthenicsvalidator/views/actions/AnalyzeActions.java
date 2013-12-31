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
public class AnalyzeActions extends Actions {

	public AnalyzeActions(ObjectCalisthenics oc,
			ViolationProvider tableProvider, TableViewer table) {
		super();
		StartRuleValidation startRuleValidation = new StartRuleValidation(oc,
				tableProvider, table);
		add(startRuleValidation);
	}

}
