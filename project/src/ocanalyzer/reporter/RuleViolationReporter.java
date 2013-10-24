package ocanalyzer.reporter;

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
public interface RuleViolationReporter {

	public abstract void reportError(IResource resource, int line, String msg);

}