package ocanalyzer.rules.wrapPrimitivesAndStrings.useWrappers;

import ocanalyzer.reporter.RuleViolationReporter;
import ocanalyzer.rules.general.ValidationHandler;

import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.dom.ASTNode;
import org.eclipse.jdt.core.dom.CompilationUnit;

public class UsePrimitivesValidationHandler extends ValidationHandler {

	public UsePrimitivesValidationHandler(ICompilationUnit unit,
			CompilationUnit compilationUnit, RuleViolationReporter reporter) {
		super(unit, compilationUnit, reporter);
	}

	@Override
	public void printInfo(ASTNode node) {
		String msg = "The use of primitives in non-wrapper classes violates rule 3";
		reportError(msg, node);
	}
}
