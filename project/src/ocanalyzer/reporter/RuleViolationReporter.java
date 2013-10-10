package ocanalyzer.reporter;

import org.eclipse.core.resources.IResource;

public interface RuleViolationReporter {

	public abstract void reportError(IResource resource, int line, String msg);

}