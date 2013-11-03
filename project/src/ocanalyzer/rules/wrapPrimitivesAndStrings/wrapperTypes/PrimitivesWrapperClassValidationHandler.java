package ocanalyzer.rules.wrapPrimitivesAndStrings.wrapperTypes;

import ocanalyzer.reporter.RuleViolationReporter;
import ocanalyzer.rules.general.ValidationHandler;

import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.dom.ASTNode;
import org.eclipse.jdt.core.dom.CompilationUnit;

public class PrimitivesWrapperClassValidationHandler extends ValidationHandler {

	public PrimitivesWrapperClassValidationHandler(ICompilationUnit unit,
			CompilationUnit compilationUnit, RuleViolationReporter reporter) {
		super(unit, compilationUnit, reporter);
	}

	@Override
	public void printInfo(ASTNode node) {
		String msg = "No rule violation. The given node seems to be a wrapper arount primitive or a String";
		reportError(msg, node);
	}
}
