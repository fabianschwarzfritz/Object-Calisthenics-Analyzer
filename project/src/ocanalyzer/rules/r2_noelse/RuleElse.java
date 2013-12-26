package ocanalyzer.rules.r2_noelse;

import ocanalyzer.reporter.ClassReporter;
import ocanalyzer.rules.general.ClassOCRuleImpl;
import ocanalyzer.rules.general.ValidationHandlerImpl;

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
		ValidationHandlerImpl instanceValidationHandler = new ElseValidationHandler(
				iUnit, unit, reporter);
		ElseVisitor visitor = new ElseVisitor(instanceValidationHandler);
		unit.accept(visitor);
	}

}
