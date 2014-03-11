package ocanalyzer.reporter.impl;

import ocanalyzer.domain.ViolationImpl;
import ocanalyzer.dto.ViolationDTO;
import ocanalyzer.reporter.Reporter;

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
public class MarkerReporter implements Reporter {

	@Override
	public void reportError(ViolationImpl violation) {
		ViolationDTO dto = violation.createDTO();

		IMarker m;
		IResource violatedResource = dto.getResource();
		try {
			m = violatedResource.createMarker(IMarker.PROBLEM);
			// FIXME: problematic because this is a String!
			m.setAttribute(IMarker.LINE_NUMBER, dto.getPosition());
			m.setAttribute(IMarker.MESSAGE, dto.getName());
			m.setAttribute(IMarker.PRIORITY, IMarker.PRIORITY_HIGH);
		} catch (CoreException e) {
			throw new RuntimeException(e);
		}
	}

}
