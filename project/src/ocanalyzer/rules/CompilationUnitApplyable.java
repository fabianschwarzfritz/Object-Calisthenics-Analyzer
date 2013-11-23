package ocanalyzer.rules;

import java.util.Collection;

import org.eclipse.jdt.core.ICompilationUnit;

public interface CompilationUnitApplyable {

	void apply(Collection<ICompilationUnit> units);

}
