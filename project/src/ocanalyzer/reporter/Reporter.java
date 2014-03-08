package ocanalyzer.reporter;

import ocanalyzer.domain.ViolationImpl;

import org.eclipse.core.resources.IResource;

/**
 * Defines all methods for all classes getting information about rule violations
 * that where found.
 * 
 * When a rule violation is found, the method
 * {@link #reportError(IResource, int, String)} is called. It gives all
 * registered listeners information about the found rule violation.
 * 
 * @author Fabian Schwarz-Fritz
 * 
 */
public interface Reporter {

	/**
	 * Reports a given {@link ViolationImpl}.
	 * 
	 * @param violation
	 *            - The {@link ViolationImpl} to report.
	 */
	public abstract void reportError(ViolationImpl violation);

}
