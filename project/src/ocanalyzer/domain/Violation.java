package ocanalyzer.domain;

import org.eclipse.core.resources.IResource;

public interface Violation {

	public IResource getResource();

	public String getMessage();

}
