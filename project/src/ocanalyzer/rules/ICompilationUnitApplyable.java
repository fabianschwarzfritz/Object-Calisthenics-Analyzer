package ocanalyzer.rules;

import java.util.Collection;

import org.eclipse.jdt.core.ICompilationUnit;

public interface ICompilationUnitApplyable {

	void apply(Collection<ICompilationUnit> units);

}
