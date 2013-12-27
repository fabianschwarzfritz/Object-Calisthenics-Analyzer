package ocanalyzer.rules.r6_small;

import ocanalyzer.reporter.ClassReporter;
import ocanalyzer.rules.general.ClassOCRuleImpl;
import ocanalyzer.rules.general.ViolationHandlerImpl;

import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.dom.CompilationUnit;

public class RuleSmallEntities extends ClassOCRuleImpl {

	private ClassReporter reporter;

	public RuleSmallEntities(ClassReporter reporter) {
		this.reporter = reporter;
	}

	@Override
	public void applyIntentiationRule(ICompilationUnit iUnit,
			CompilationUnit unit) {
		ViolationHandlerImpl instanceValidationHandler = new SmallViolationHandler(
				iUnit, unit, reporter);
		SmallVisitor visitor = new SmallVisitor(instanceValidationHandler);
		unit.accept(visitor);
	}

}
