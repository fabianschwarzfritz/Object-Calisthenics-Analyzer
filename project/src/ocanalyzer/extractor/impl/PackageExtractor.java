package ocanalyzer.extractor.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.IPackageFragment;
import org.eclipse.jdt.core.IPackageFragmentRoot;
import org.eclipse.jdt.core.JavaModelException;

public class PackageExtractor implements CompilationUnitsExtractable {

	private ExtractorFactory factory;
	private IPackageFragment packageFragement;

	public PackageExtractor(IPackageFragment mypackage, ExtractorFactory factory) {
		this.packageFragement = mypackage;
		this.factory = factory;
	}

	@Override
	public Collection<ICompilationUnit> extractCompilationUnits() {
		try {
			if (packageFragement.getKind() == IPackageFragmentRoot.K_SOURCE) {
				List<ICompilationUnit> extractUnits = extractUnits();
				// FIXME remove counting of classes
				// ClassesPerPackage classes = new ClassesPerPackage(
				// packageFragement, writer);
				// classes.setCount(extractUnits.size());
				return extractUnits;
			}
		} catch (JavaModelException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return new ArrayList<ICompilationUnit>();
	}

	private List<ICompilationUnit> extractUnits() throws JavaModelException {
		List<ICompilationUnit> result = new ArrayList<ICompilationUnit>();
		for (ICompilationUnit unit : packageFragement.getCompilationUnits()) {
			result.add(unit);
		}
		return result;
	}
}
