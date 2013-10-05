package ocanalyzer.analyzer;

import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.IPackageFragment;
import org.eclipse.jdt.core.IPackageFragmentRoot;
import org.eclipse.jdt.core.JavaModelException;

public class PackageAnalyzer {
	
	private IPackageFragment packageFragement;

	public PackageAnalyzer(IPackageFragment mypackage) {
		this.packageFragement = mypackage;
	}
	
	public void handle() {
		try {
			if (packageFragement.getKind() == IPackageFragmentRoot.K_SOURCE) {
				for (ICompilationUnit unit : packageFragement.getCompilationUnits()) {
					CompilationUnitAnalyzer handler = new CompilationUnitAnalyzer(unit);
					handler.handle();
				}
			}
		} catch (JavaModelException e) {
			e.printStackTrace();
		}
	}

}
