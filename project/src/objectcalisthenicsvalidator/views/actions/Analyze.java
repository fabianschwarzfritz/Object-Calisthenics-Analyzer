/**
 * 
 */
package objectcalisthenicsvalidator.views.actions;

import objectcalisthenicsvalidator.views.table.ViolationProvider;
import ocanalyzer.domain.Training;

/**
 * @author Fabian Schwarz-Fritz
 * 
 */
public class Analyze extends Actions {

	public Analyze(Training training, ViolationProvider modelProvider) {
		super();
		StartRuleValidation startRuleValidation = new StartRuleValidation(
				training, modelProvider);
		ClearMarker clearMarker = new ClearMarker();
		add(startRuleValidation);
		add(clearMarker);
	}

}
