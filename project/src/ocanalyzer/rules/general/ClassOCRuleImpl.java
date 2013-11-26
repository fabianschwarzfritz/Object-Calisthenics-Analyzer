package ocanalyzer.rules.general;

import ocanalyzer.extractor.impl.ASTNodeFactory;

import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.dom.CompilationUnit;

public abstract class ClassOCRuleImpl implements OCRule {

	public abstract void applyIntentiationRule(ICompilationUnit iUnit,
			CompilationUnit unit);

	public void apply(ICompilationUnits units) {
		units.each(new ICompilationUnitEvent() {
			@Override
			public void push(ICompilationUnit iUnit) {
				CompilationUnit unit = createUnit(iUnit);
				applyIntentiationRule(iUnit, unit);
			}
		});
	}

	public CompilationUnit createUnit(ICompilationUnit iUnit) {
		CompilationUnit unit = (CompilationUnit) new ASTNodeFactory()
				.parse(iUnit);
		return unit;
	}

}
