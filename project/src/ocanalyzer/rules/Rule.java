package ocanalyzer.rules;

import java.util.Collection;

import ocanalyzer.extractor.impl.ASTNodeFactory;

import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.dom.CompilationUnit;

public abstract class Rule {

	public abstract void validate(Collection<ICompilationUnit> units);

	public CompilationUnit createUnit(ICompilationUnit iUnit) {
		CompilationUnit unit = (CompilationUnit) new ASTNodeFactory()
				.parse(iUnit);
		return unit;
	}

}
