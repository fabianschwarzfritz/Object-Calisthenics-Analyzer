package ocanalyzer.domain;

import org.eclipse.core.resources.IResource;

public class PositionInClass implements Position {

	private IResource resource;
	private Integer line;

	public PositionInClass(IResource resource, Integer line) {
		this.resource = resource;
		this.line = line;
	}

	public int getPosition() {
		return line;
	}

	public IResource getResource() {
		return resource;
	}

	@Override
	public String createDTO() {
		return line.toString();
	}

}
