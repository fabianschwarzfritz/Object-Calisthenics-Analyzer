package ocanalyzer.rules.r7_instanceVariable;

import ocanalyzer.reporter.ClassReporter;
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

	private ClassReporter reporter;

	public RuleInstanceVariable(ClassReporter reporter) {
		this.reporter = reporter;
	}

	@Override
	public void applyIntentiationRule(ICompilationUnit iUnit,
			CompilationUnit unit) {
		ViolationHandlerImpl instanceValidationHandler = new InstanceVariableViolationHandler(
				iUnit, unit, reporter);
		InstanceVariableVisitor visitor = new InstanceVariableVisitor(
				instanceValidationHandler);
		unit.accept(visitor);
	}

}
