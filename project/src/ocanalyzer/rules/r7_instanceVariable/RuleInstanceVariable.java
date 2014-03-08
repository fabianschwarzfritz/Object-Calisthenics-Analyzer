package ocanalyzer.rules.r7_instanceVariable;

import ocanalyzer.reporter.Reporter;
import ocanalyzer.rules.general.ClassOCRuleImpl;
import ocanalyzer.rules.general.ViolationHandlerImpl;

import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.dom.CompilationUnit;

/**
 * Visitor for rule:
 * "Don't use any classes with more than two instance variables"
 * 
 * @author Fabian Schwarz-Fritz
 * 
 */

public class RuleInstanceVariable extends ClassOCRuleImpl {

	private Reporter reporter;

	public RuleInstanceVariable(Reporter reporter) {
		this.reporter = reporter;
	}

	@Override
	public void applyIntentiationRule(ICompilationUnit iUnit,
			CompilationUnit unit) {
		ViolationHandlerImpl instanceViolationHandler = new InstanceVariableViolationHandler(
				iUnit, unit, reporter);
		InstanceVariableVisitor visitor = new InstanceVariableVisitor(
				instanceViolationHandler);
		unit.accept(visitor);
	}

}
