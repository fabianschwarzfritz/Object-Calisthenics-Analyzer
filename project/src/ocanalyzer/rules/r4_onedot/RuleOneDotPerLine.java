package ocanalyzer.rules.r4_onedot;

import ocanalyzer.reporter.ClassReporter;
import ocanalyzer.rules.general.ClassOCRuleImpl;
import ocanalyzer.rules.general.ViolationHandlerImpl;

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
		ViolationHandlerImpl instanceValidationHandler = new DotViolationHandler(
				iUnit, unit, reporter);
		DotVisitor visitor = new DotVisitor(instanceValidationHandler);
		unit.accept(visitor);
	}

}
