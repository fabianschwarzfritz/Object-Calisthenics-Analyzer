package ocanalyzer.rules.r3_8_wrap.collections;

import ocanalyzer.reporter.ClassReporter;
import ocanalyzer.rules.general.ViolationHandlerImpl;

import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.dom.ASTNode;
import org.eclipse.jdt.core.dom.CompilationUnit;

class CollectionReturnViolationHandler extends ViolationHandlerImpl {

	public CollectionReturnViolationHandler(ICompilationUnit unit,
			CompilationUnit compilationUnit, ClassReporter reporter) {
		super(unit, compilationUnit, reporter);
	}

	@Override
	public void printInfo(ASTNode node) {
		String msg = "Returning a collection type in a wrapper classes violates rule 8";
		reportError(msg, node);
	}

	@Override
	public void printInfo(ASTNode type, String customMessage) {
		reportError(customMessage, type);
	}
}
