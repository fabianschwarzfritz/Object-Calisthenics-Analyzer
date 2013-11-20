package ocanalyzer.analyzer.factory.extractor;

import ocanalyzer.reporter.PackageReporter;
import ocanalyzer.reporter.PackageViolation;

import org.eclipse.jdt.core.IPackageFragment;

public class ClassesPerPackage {

	private IPackageFragment fragment;
	private PackageReporter writer;

	public ClassesPerPackage(IPackageFragment fragment, PackageReporter writer) {
		this.fragment = fragment;
		this.writer = writer;
	}

	public void setCount(int count) {
		if (count > 10) {
			writer.reportError(new PackageViolation(fragment,
					"Maximum 10 classes per package!"));
		}
	}

}
