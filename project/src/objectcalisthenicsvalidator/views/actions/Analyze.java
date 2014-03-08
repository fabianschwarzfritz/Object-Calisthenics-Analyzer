/**
 * 
 */
package objectcalisthenicsvalidator.views.actions;

import objectcalisthenicsvalidator.views.table.ViolationProvider;
import ocanalyzer.domain.Training;
import ocanalyzer.reporter.Reporter;

import org.eclipse.jface.viewers.TableViewer;

/**
 * @author Fabian Schwarz-Fritz
 * 
 */
public class Analyze extends Actions {

	public Analyze(Training training, Reporter reporter,
			ViolationProvider tableProvider, TableViewer table) {
		super();
		StartRuleValidation startRuleValidation = new StartRuleValidation(
				training, reporter, tableProvider, table);
		ClearMarker clearMarker = new ClearMarker();
		add(startRuleValidation);
		add(clearMarker);
	}

}
