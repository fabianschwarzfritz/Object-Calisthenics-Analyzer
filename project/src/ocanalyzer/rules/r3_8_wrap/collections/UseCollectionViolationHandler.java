package ocanalyzer.rules.r3_8_wrap.collections;

import ocanalyzer.reporter.ClassReporter;
import ocanalyzer.rules.general.ValidationHandler;

import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.dom.ASTNode;
import org.eclipse.jdt.core.dom.CompilationUnit;

public class UseCollectionViolationHandler extends ValidationHandler {

	public UseCollectionViolationHandler(ICompilationUnit unit,
			CompilationUnit compilationUnit, ClassReporter reporter) {
		super(unit, compilationUnit, reporter);
	}

	@Override
	public void printInfo(ASTNode node) {
		String msg = "The use of collections in non-wrapper classes violates rule 8";
		reportError(msg, node);
	}
}
