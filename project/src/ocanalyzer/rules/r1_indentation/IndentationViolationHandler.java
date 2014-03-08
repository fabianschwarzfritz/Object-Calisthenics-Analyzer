package ocanalyzer.rules.r1_indentation;

import ocanalyzer.reporter.Reporter;
import ocanalyzer.rules.general.ViolationHandlerImpl;

import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.dom.ASTNode;
import org.eclipse.jdt.core.dom.CompilationUnit;

class IndentationViolationHandler extends ViolationHandlerImpl {

	public IndentationViolationHandler(ICompilationUnit unit,
			CompilationUnit compilationUnit, Reporter reporter) {
		super(unit, compilationUnit, reporter);
	}

	@Override
	public void printInfo(ASTNode node) {
		String msg = "The given indentation violates rule 1";
		reportError(msg, node);
	}

	@Override
	public void printInfo(ASTNode type, String customMessage) {
		reportError(customMessage, type);
	}

}
