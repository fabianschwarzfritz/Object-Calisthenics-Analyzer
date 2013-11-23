package ocanalyzer.rules.general;

import java.util.Collection;

import ocanalyzer.extractor.impl.ASTNodeFactory;
import ocanalyzer.rules.ObjectCalisthenicsRule;

import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.dom.CompilationUnit;

public abstract class ClassOCRuleImpl implements ObjectCalisthenicsRule {

	public abstract void applyIntentiationRule(ICompilationUnit iUnit,
			CompilationUnit unit);

	public void apply(Collection<ICompilationUnit> units) {
		for (ICompilationUnit iUnit : units) {
			CompilationUnit unit = createUnit(iUnit);
			applyIntentiationRule(iUnit, unit);
		}
	}

	public CompilationUnit createUnit(ICompilationUnit iUnit) {
		CompilationUnit unit = (CompilationUnit) new ASTNodeFactory()
				.parse(iUnit);
		return unit;
	}

}
