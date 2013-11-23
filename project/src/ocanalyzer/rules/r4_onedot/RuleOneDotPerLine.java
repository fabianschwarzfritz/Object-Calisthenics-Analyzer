package ocanalyzer.rules.r4_onedot;

import ocanalyzer.reporter.ClassReporter;
import ocanalyzer.rules.general.ClassOCRuleImpl;
import ocanalyzer.rules.general.ValidationHandler;

import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.dom.CompilationUnit;

public class RuleOneDotPerLine extends ClassOCRuleImpl {

	private ClassReporter reporter;

	public RuleOneDotPerLine(ClassReporter reporter) {
		this.reporter = reporter;
	}

	@Override
	public void applyIntentiationRule(ICompilationUnit iUnit,
			CompilationUnit unit) {
		ValidationHandler instanceValidationHandler = new DotValidationHandler(
				iUnit, unit, reporter);
		DotVisitor visitor = new DotVisitor(instanceValidationHandler);
		unit.accept(visitor);
	}

}
