package ocanalyzer.reporter;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;

/**
 * This class is used to display information about rule violation in the editor
 * line.
 * 
 * @author Fabian Schwarz-Fritz
 * 
 */
public class MarkerReporter implements RuleViolationReporter {

	@Override
	public void reportError(Violation violation) {
		IMarker m;
		IResource violatedResource = violation.getResource();
		try {
			m = violatedResource.createMarker(IMarker.PROBLEM);
			m.setAttribute(IMarker.LINE_NUMBER, violation.getLine());
			m.setAttribute(IMarker.MESSAGE, violation.getMessage());
			m.setAttribute(IMarker.PRIORITY, IMarker.PRIORITY_HIGH);
		} catch (CoreException e) {
			throw new RuntimeException(e);
		}
	}

}
