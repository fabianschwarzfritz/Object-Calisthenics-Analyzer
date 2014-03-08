package ocanalyzer.reporter;

import ocanalyzer.domain.Violation;

import org.eclipse.core.resources.IResource;
import org.eclipse.jdt.core.IPackageFragment;

public class PackageViolation implements Violation {

	private IPackageFragment fragment;
	private String message;

	public PackageViolation(IPackageFragment fragment, String message) {
		super();
		this.fragment = fragment;
		this.message = message;
	}

	public IResource getResource() {
		return fragment.getResource();
	}

	public String getMessage() {
		return message;
	}

}
