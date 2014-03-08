package ocanalyzer.extractor.impl;

import ocanalyzer.domain.ViolationFactory;
import ocanalyzer.reporter.Reporter;

import org.eclipse.jdt.core.IPackageFragment;

public class ClassesPerPackage {

	private IPackageFragment fragment;
	private Reporter writer;

	public ClassesPerPackage(IPackageFragment fragment, Reporter writer) {
		this.fragment = fragment;
		this.writer = writer;
	}

	public void setCount(int count) {
		if (count > 10) {
			writer.reportError(ViolationFactory.createPackageViolation(
					fragment, "Maximum 10 classes per package!"));
		}
	}

}
