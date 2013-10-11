package ocanalyzer.analyzer;

import java.util.List;

import org.eclipse.jdt.core.dom.CompilationUnit;

public interface CompilationUnitsExtractable {

	public abstract  List<CompilationUnit> extractCompilationUnits();

}
