package ocanalyzer.domain;

import org.eclipse.core.resources.IResource;

public class Position {

	private IResource resource;
	private Integer line;

	public Position(IResource resource, Integer line) {
		this.resource = resource;
		this.line = line;
	}

	public int getPosition() {
		return line;
	}

	public IResource getResource() {
		return resource;
	}

}
