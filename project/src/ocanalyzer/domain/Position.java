package ocanalyzer.domain;

import org.eclipse.core.resources.IResource;

public interface Position {

	public abstract int getPosition();

	public abstract IResource getResource();

	public abstract String createDTO();
}
