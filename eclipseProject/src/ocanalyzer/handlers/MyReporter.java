package ocanalyzer.handlers;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;

/**
 * This class is used to display information to the users about rule
 * validations.
 * 
 * @author Fabian Schwarz-Fritz
 * 
 */

public class MyReporter {

	public void reportError(IResource resource, int line, String msg)
			throws CoreException {
		IMarker m = resource.createMarker(IMarker.TASK);
		m.setAttribute(IMarker.LINE_NUMBER, line);
		m.setAttribute(IMarker.MESSAGE, msg);
		m.setAttribute(IMarker.PRIORITY, IMarker.PRIORITY_NORMAL);
		m.setAttribute(IMarker.SEVERITY, IMarker.MARKER);
	}

}
