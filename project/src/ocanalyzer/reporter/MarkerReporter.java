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
	public void reportError(IResource resource, int line, String msg) {
		IMarker m;
		try {
			m = resource.createMarker(IMarker.PROBLEM);
			m.setAttribute(IMarker.LINE_NUMBER, line);
			m.setAttribute(IMarker.MESSAGE, msg);
			m.setAttribute(IMarker.PRIORITY, IMarker.PRIORITY_HIGH);
		} catch (CoreException e) {
			throw new RuntimeException(e);
		}
	}

}
