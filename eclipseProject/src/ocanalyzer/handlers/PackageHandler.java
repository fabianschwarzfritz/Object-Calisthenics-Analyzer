package ocanalyzer.handlers;

import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.IPackageFragment;
import org.eclipse.jdt.core.IPackageFragmentRoot;
import org.eclipse.jdt.core.JavaModelException;

public class PackageHandler {
	
	private IPackageFragment packageFragement;

	public PackageHandler(IPackageFragment mypackage) {
		this.packageFragement = mypackage;
	}
	
	public void handle() {
		try {
			if (packageFragement.getKind() == IPackageFragmentRoot.K_SOURCE) {
				for (ICompilationUnit unit : packageFragement.getCompilationUnits()) {
					CompilationUnitHandler handler = new CompilationUnitHandler(unit);
					handler.handle();
				}
			}
		} catch (JavaModelException e) {
			e.printStackTrace();
		}
	}

}
