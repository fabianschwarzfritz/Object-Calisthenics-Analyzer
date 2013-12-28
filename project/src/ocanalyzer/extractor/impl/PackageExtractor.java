package ocanalyzer.extractor.impl;

import ocanalyzer.rules.general.ICompilationUnits;

import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.IPackageFragment;
import org.eclipse.jdt.core.IPackageFragmentRoot;
import org.eclipse.jdt.core.JavaModelException;

public class PackageExtractor implements CompilationUnitsExtractable {

	private IPackageFragment packageFragement;

	public PackageExtractor(IPackageFragment mypackage) {
		this.packageFragement = mypackage;
	}

	@Override
	public ICompilationUnits extractCompilationUnits() {
		try {
			if (packageFragement.getKind() == IPackageFragmentRoot.K_SOURCE) {
				ICompilationUnits units = extractUnits();
				// FIXME remove counting of classes
				// ClassesPerPackage classes = new ClassesPerPackage(
				// packageFragement, writer);
				// classes.setCount(extractUnits.size());
				return units;
			}
		} catch (JavaModelException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return new ICompilationUnits();
	}

	private ICompilationUnits extractUnits() throws JavaModelException {
		ICompilationUnits result = new ICompilationUnits();
		for (ICompilationUnit unit : packageFragement.getCompilationUnits()) {
			result.add(unit);
		}
		return result;
	}
}
