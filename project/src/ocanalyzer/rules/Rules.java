package ocanalyzer.rules;

import java.util.Collection;

import org.eclipse.jdt.core.dom.CompilationUnit;

public interface Rules {

	void apply(Collection<CompilationUnit> units);

}
