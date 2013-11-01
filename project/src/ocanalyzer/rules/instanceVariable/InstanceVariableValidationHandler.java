package ocanalyzer.rules.instanceVariable;

import ocanalyzer.reporter.RuleViolationReporter;
import ocanalyzer.rules.general.ValidationHandler;

import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.Statement;

public class InstanceVariableValidationHandler extends ValidationHandler {

	public InstanceVariableValidationHandler(ICompilationUnit unit,
			CompilationUnit compilationUnit, RuleViolationReporter reporter) {
		super(unit, compilationUnit, reporter);
	}

	@Override
	public void printInfo(Statement statement) {
		String msg = "The else keyword violates rule 7";
		reportError(msg, statement);
	}
}