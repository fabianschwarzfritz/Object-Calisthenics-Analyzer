package ocanalyzer.extractor;

import java.util.Collection;

import org.eclipse.jdt.core.ICompilationUnit;

public interface Extractor {

	Collection<ICompilationUnit> extract();

}
