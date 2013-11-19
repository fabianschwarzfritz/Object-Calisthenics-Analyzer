package ocanalyzer.analyzer.factory.extractor;

import java.util.List;

import org.eclipse.jdt.core.dom.CompilationUnit;

interface CompilationUnitsExtractable {

	public abstract List<CompilationUnit> extractCompilationUnits();

}
