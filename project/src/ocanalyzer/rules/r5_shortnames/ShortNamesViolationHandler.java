package ocanalyzer.rules.r5_shortnames;

import ocanalyzer.reporter.ClassReporter;
import ocanalyzer.rules.general.ViolationHandlerImpl;

import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.dom.ASTNode;
import org.eclipse.jdt.core.dom.CompilationUnit;

class ShortNamesViolationHandler extends ViolationHandlerImpl {

	public ShortNamesViolationHandler(ICompilationUnit unit,
			CompilationUnit compilationUnit, ClassReporter reporter) {
		super(unit, compilationUnit, reporter);
	}

	@Override
	public void printInfo(ASTNode node) {
		String msg = "No Abbreviations but short names!";
		reportError(msg, node);
	}

	@Override
	public void printInfo(ASTNode type, String customMessage) {
		reportError(customMessage, type);
	}

}
