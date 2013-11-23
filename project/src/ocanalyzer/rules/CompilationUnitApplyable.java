package ocanalyzer.rules;

import java.util.Collection;

import org.eclipse.jdt.core.dom.CompilationUnit;

public interface CompilationUnitApplyable {

	void apply(Collection<CompilationUnit> units);

}
