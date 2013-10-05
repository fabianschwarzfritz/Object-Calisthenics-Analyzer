package ocanalyzer.reporter;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;

public interface RuleViolationReporter {

	public abstract void reportError(IResource resource, int line, String msg);

}