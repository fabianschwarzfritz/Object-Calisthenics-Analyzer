package ocanalyzer.extractor.impl;

import ocanalyzer.domain.ViolationFactory;
import ocanalyzer.reporter.ClassReporter;

import org.eclipse.jdt.core.IPackageFragment;

public class ClassesPerPackage {

	private IPackageFragment fragment;
	private ClassReporter writer;

	public ClassesPerPackage(IPackageFragment fragment, ClassReporter writer) {
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
