package ocanalyzer.rules.instanceVariable;

import ocanalyzer.reporter.RuleViolationReporter;
import ocanalyzer.rules.general.RuleValidatorFactory;
import ocanalyzer.rules.general.ValidationHandler;

import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.CompilationUnit;

public class InstanceVariableFactory extends RuleValidatorFactory {

	public InstanceVariableFactory(ICompilationUnit unit,
			CompilationUnit compilationUnit, RuleViolationReporter reporter) {
		super(unit, compilationUnit, reporter);
	}

	@Override
	public ASTVisitor create() {
		ValidationHandler instanceValidationHandler = new InstanceVariableValidationHandler(
				unit, compilationUnit, reporter);
		InstanceVariableVisitor visitor = new InstanceVariableVisitor(
				instanceValidationHandler);
		return visitor;
	}
}
