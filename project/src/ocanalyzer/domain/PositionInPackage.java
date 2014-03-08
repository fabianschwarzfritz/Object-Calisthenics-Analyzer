package ocanalyzer.domain;

import org.eclipse.core.resources.IResource;
import org.eclipse.jdt.core.IPackageFragment;

public class PositionInPackage implements Position {

	private IPackageFragment fragment;

	public PositionInPackage(IPackageFragment fragment) {
		super();
		this.fragment = fragment;
	}

	public IResource getResource() {
		return fragment.getResource();
	}

	@Override
	public int getPosition() {
		return 0;
	}

}
