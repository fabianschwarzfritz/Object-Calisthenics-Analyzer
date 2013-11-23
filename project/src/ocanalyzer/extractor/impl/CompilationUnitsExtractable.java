package ocanalyzer.extractor.impl;

import java.util.Collection;
import java.util.List;

import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.dom.CompilationUnit;

interface CompilationUnitsExtractable {

	public abstract Collection<ICompilationUnit> extractCompilationUnits();

}
