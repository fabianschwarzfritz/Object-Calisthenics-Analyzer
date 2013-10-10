package ocanalyzer.analyzer;

import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.IPackageFragment;
import org.eclipse.jdt.core.IPackageFragmentRoot;
import org.eclipse.jdt.core.JavaModelException;

public class PackageAnalyzer {

	private AnalyzerFactory factory;
	private IPackageFragment packageFragement;

	public PackageAnalyzer(IPackageFragment mypackage, AnalyzerFactory factory) {
		this.packageFragement = mypackage;
		this.factory = factory;
	}

	public void handle() {
		try {
			if (packageFragement.getKind() == IPackageFragmentRoot.K_SOURCE) {
				for (ICompilationUnit unit : packageFragement
						.getCompilationUnits()) {
					CompilationUnitAnalyzer handler = factory
							.createCompilationUnitAnalyzer(unit);
					handler.handle();
				}
			}
		} catch (JavaModelException e) {
			e.printStackTrace();
		}
	}

}
