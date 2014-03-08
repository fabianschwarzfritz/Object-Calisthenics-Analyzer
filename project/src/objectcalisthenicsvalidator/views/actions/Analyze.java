/**
 * 
 */
package objectcalisthenicsvalidator.views.actions;

import objectcalisthenicsvalidator.views.table.ViolationProvider;
import ocanalyzer.domain.Training;

import org.eclipse.jface.viewers.TableViewer;

/**
 * @author Fabian Schwarz-Fritz
 * 
 */
public class Analyze extends Actions {

	public Analyze(Training training, ViolationProvider tableProvider,
			TableViewer table) {
		super();
		StartRuleValidation startRuleValidation = new StartRuleValidation(
				training, tableProvider, table);
		ClearMarker clearMarker = new ClearMarker();
		add(startRuleValidation);
		add(clearMarker);
	}

}
