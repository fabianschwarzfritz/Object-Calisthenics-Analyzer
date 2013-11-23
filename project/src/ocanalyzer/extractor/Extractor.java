package ocanalyzer.extractor;

import java.util.Collection;

import org.eclipse.jdt.core.dom.CompilationUnit;

public interface Extractor {

	Collection<CompilationUnit> extract();

}
