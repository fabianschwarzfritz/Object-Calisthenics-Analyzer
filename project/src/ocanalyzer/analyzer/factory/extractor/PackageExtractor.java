package ocanalyzer.analyzer.factory.extractor;

import java.util.ArrayList;
import java.util.List;

import ocanalyzer.analyzer.factory.ExtractorFactory;
import ocanalyzer.reporter.PackageReporter;

import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.IPackageFragment;
import org.eclipse.jdt.core.IPackageFragmentRoot;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.core.dom.CompilationUnit;

public class PackageExtractor implements CompilationUnitsExtractable {

	private ExtractorFactory factory;
	private IPackageFragment packageFragement;
	private PackageReporter writer;

	public PackageExtractor(IPackageFragment mypackage,
			ExtractorFactory factory, PackageReporter writer) {
		this.packageFragement = mypackage;
		this.factory = factory;
		this.writer = writer;
	}

	@Override
	public List<CompilationUnit> extractCompilationUnits() {
		try {
			if (packageFragement.getKind() == IPackageFragmentRoot.K_SOURCE) {
				List<CompilationUnit> extractUnits = extractUnits();
				ClassesPerPackage classes = new ClassesPerPackage(
						packageFragement, writer);
				classes.setCount(extractUnits.size());
				return extractUnits;
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
			CompilationUnitExtractor handler = factory
					.createCompilationUnitAnalyzer(unit);
			result.addAll(handler.extractCompilationUnits());
		}
		return result;
	}
}
