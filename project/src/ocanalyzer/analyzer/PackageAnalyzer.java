package ocanalyzer.analyzer;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.IPackageFragment;
import org.eclipse.jdt.core.IPackageFragmentRoot;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.core.dom.CompilationUnit;

public class PackageAnalyzer implements CompilationUnitsExtractable {

	private AnalyzerFactory factory;
	private IPackageFragment packageFragement;

	public PackageAnalyzer(IPackageFragment mypackage, AnalyzerFactory factory) {
		this.packageFragement = mypackage;
		this.factory = factory;
	}

	@Override
	public List<CompilationUnit> extractCompilationUnits() {
		try {
			if (packageFragement.getKind() == IPackageFragmentRoot.K_SOURCE) {
				return extractUnits();
			}
		} catch (JavaModelException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return new ArrayList<CompilationUnit>();
	}

	private List<CompilationUnit> extractUnits() throws JavaModelException {
		List<CompilationUnit> result = new ArrayList<CompilationUnit>();
		for (ICompilationUnit unit : packageFragement.getCompilationUnits()) {
			CompilationUnitAnalyzer handler = factory
					.createCompilationUnitAnalyzer(unit);
			result.addAll(handler.extractCompilationUnits());
		}
		return result;
	}
}