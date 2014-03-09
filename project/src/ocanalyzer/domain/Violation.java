package ocanalyzer.domain;

import ocanalyzer.dto.ViolationDTO;

import org.eclipse.core.resources.IResource;

public interface Violation {

	public IResource getResource();

	public String getMessage();

	public ViolationDTO createDTO();

}
