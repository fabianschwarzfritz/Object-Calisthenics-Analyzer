package ocanalyzer.rules.r6_small;

import ocanalyzer.reporter.ClassReporter;
import ocanalyzer.rules.general.ClassOCRuleImpl;
import ocanalyzer.rules.general.ValidationHandlerImpl;

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
		ValidationHandlerImpl instanceValidationHandler = new SmallValidationHandler(
				iUnit, unit, reporter);
		SmallVisitor visitor = new SmallVisitor(instanceValidationHandler);
		unit.accept(visitor);
	}

}
