package ocanalyzer.rules.instanceVariable;

import ocanalyzer.reporter.ClassReporter;
import ocanalyzer.rules.general.ClassOCRuleImpl;
import ocanalyzer.rules.general.ValidationHandler;

import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.dom.CompilationUnit;

public class RuleInstanceVariable extends ClassOCRuleImpl {

	private ClassReporter reporter;

	public RuleInstanceVariable(ClassReporter reporter) {
		this.reporter = reporter;
	}

	@Override
	public void applyIntentiationRule(ICompilationUnit iUnit,
			CompilationUnit unit) {
		ValidationHandler instanceValidationHandler = new InstanceVariableValidationHandler(
				iUnit, unit, reporter);
		InstanceVariableVisitor visitor = new InstanceVariableVisitor(
				instanceValidationHandler);
		unit.accept(visitor);
	}

}
