package ocanalyzer.rules.r2_noelse;

import ocanalyzer.reporter.ClassReporter;
import ocanalyzer.rules.general.ClassOCRuleImpl;
import ocanalyzer.rules.general.ViolationHandlerImpl;

import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.dom.CompilationUnit;

public class RuleElse extends ClassOCRuleImpl {

	private ClassReporter reporter;

	public RuleElse(ClassReporter reporter) {
		this.reporter = reporter;
	}

	@Override
	public void applyIntentiationRule(ICompilationUnit iUnit,
			CompilationUnit unit) {
		ViolationHandlerImpl instanceValidationHandler = new ElseViolationHandler(
				iUnit, unit, reporter);
		ElseVisitor visitor = new ElseVisitor(instanceValidationHandler);
		unit.accept(visitor);
	}

}
