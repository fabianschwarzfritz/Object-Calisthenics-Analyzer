package ocanalyzer.analyzer.factory.extractor;

import java.util.ArrayList;
import java.util.List;

import ocanalyzer.analyzer.factory.ASTNodeFactory;

import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.dom.CompilationUnit;

/**
 * 
 * This class creates the AST tree of a Java class to examine.
 * 
 * Therefore the {@link #handle()} method creates an AST tree and adds all
 * visitors to the Java class's {@link CompilationUnit}
 * 
 * @author Fabian Schwarz-Fritz
 * 
 */
public class CompilationUnitExtractor implements CompilationUnitsExtractable {

	protected ICompilationUnit unit;

	public CompilationUnitExtractor(ICompilationUnit unit) {
		this.unit = unit;
	}

	@Override
	public List<CompilationUnit> extractCompilationUnits() {
		List<CompilationUnit> resultUnits = new ArrayList<CompilationUnit>();
		CompilationUnit compilationUnit = (CompilationUnit) new ASTNodeFactory()
				.parse(unit);
		resultUnits.add(compilationUnit);
		return resultUnits;
	}
}
