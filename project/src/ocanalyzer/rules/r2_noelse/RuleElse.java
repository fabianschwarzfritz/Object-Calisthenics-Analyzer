package ocanalyzer.rules.r2_noelse;

import ocanalyzer.reporter.Reporter;
import ocanalyzer.rules.general.ClassOCRuleImpl;
import ocanalyzer.rules.general.ViolationHandlerImpl;

import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.dom.CompilationUnit;

/**
 * Rule: "Don�t Use the else Keyword".
 * 
 * @see ElseVisitor for more information
 * 
 * @author Fabian Schwarz-Fritz
 * 
 */

public class RuleElse extends ClassOCRuleImpl {

	private Reporter reporter;

	public RuleElse(Reporter reporter) {
		this.reporter = reporter;
	}

	@Override
	public void applyRule(ICompilationUnit iUnit,
			CompilationUnit unit) {
		ViolationHandlerImpl instanceViolationHandler = new ElseViolationHandler(
				iUnit, unit, reporter);
		ElseVisitor visitor = new ElseVisitor(instanceViolationHandler);
		unit.accept(visitor);

	}

}
