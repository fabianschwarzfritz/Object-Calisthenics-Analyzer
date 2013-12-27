package ocanalyzer.rules.r5_shortnames;

import ocanalyzer.reporter.ClassReporter;
import ocanalyzer.rules.general.ClassOCRuleImpl;
import ocanalyzer.rules.general.ViolationHandlerImpl;

import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.dom.CompilationUnit;

public class RuleShortNames extends ClassOCRuleImpl {

	private ClassReporter reporter;

	public RuleShortNames(ClassReporter reporter) {
		this.reporter = reporter;
	}

	@Override
	public void applyIntentiationRule(ICompilationUnit iUnit,
			CompilationUnit unit) {
		ViolationHandlerImpl shortNamesHandler = new ShortNamesViolationHandler(
				iUnit, unit, reporter);
		ShortNamesVisitor visitor = new ShortNamesVisitor(shortNamesHandler);
		unit.accept(visitor);
	}

}
