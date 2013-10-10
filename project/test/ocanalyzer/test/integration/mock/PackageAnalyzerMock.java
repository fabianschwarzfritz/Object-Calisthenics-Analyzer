package ocanalyzer.test.integration.mock;

import org.eclipse.jdt.core.IPackageFragment;

import ocanalyzer.analyzer.AnalyzerFactory;
import ocanalyzer.analyzer.PackageAnalyzer;

public class PackageAnalyzerMock extends PackageAnalyzer {

	public PackageAnalyzerMock(IPackageFragment mypackage, AnalyzerFactory factory) {
		super(mypackage, factory);
	}

}
