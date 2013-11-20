package ocanalyzer.reporter;

import org.eclipse.jdt.core.IPackageFragment;

public class PackageViolation implements Violation {

	private IPackageFragment fragment;
	private String message;

	public PackageViolation(IPackageFragment fragment, String message) {
		super();
		this.fragment = fragment;
		this.message = message;
	}

	public IPackageFragment getFragment() {
		return fragment;
	}

	public void setFragment(IPackageFragment fragment) {
		this.fragment = fragment;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
