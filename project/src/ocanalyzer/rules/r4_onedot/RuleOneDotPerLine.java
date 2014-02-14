package ocanalyzer.rules.r4_onedot;

import ocanalyzer.reporter.ClassReporter;
import ocanalyzer.rules.general.ClassOCRuleImpl;
import ocanalyzer.rules.general.ViolationHandlerImpl;

import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.dom.CompilationUnit;

/**
 * Rule: "Don�t Use the else Keyword".
 * 
 * @author Fabian Schwarz-Fritz
 * 
 */

public class RuleOneDotPerLine extends ClassOCRuleImpl {

	private ClassReporter reporter;

	public RuleOneDotPerLine(ClassReporter reporter) {
		this.reporter = reporter;
	}

	@Override
	public void applyIntentiationRule(ICompilationUnit iUnit,
			CompilationUnit unit) {
		ViolationHandlerImpl instanceViolationHandler = new DotViolationHandler(
				iUnit, unit, reporter);
		DotVisitor visitor = new DotVisitor(instanceViolationHandler);
		unit.accept(visitor);
	}

}
