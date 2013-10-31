package ocanalyzer.rules.wrapPrimitivesAndStrings;

import ocanalyzer.reporter.RuleViolationReporter;
import ocanalyzer.rules.general.ValidationHandler;

import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.Statement;

public class WrapPrimitivesValidationHandler extends ValidationHandler {

	public WrapPrimitivesValidationHandler(ICompilationUnit unit,
			CompilationUnit compilationUnit, RuleViolationReporter reporter) {
		super(unit, compilationUnit, reporter);
	}

	@Override
	public void printInfo(Statement statement) {
		String msg = "The use of primitives violates rule 3";
		reportError(msg, statement);
	}
}
