package ocanalyzer.rules.r3_8_wrap.collections;

import ocanalyzer.reporter.ClassReporter;
import ocanalyzer.rules.general.ValidationHandlerImpl;

import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.dom.ASTNode;
import org.eclipse.jdt.core.dom.CompilationUnit;

public class CollectionWrapperClassViolationHandler extends ValidationHandlerImpl {

	public CollectionWrapperClassViolationHandler(ICompilationUnit unit,
			CompilationUnit compilationUnit, ClassReporter reporter) {
		super(unit, compilationUnit, reporter);
	}

	@Override
	public void printInfo(ASTNode node) {
		String msg = "The use of more than one instance variable in collection wrapper classes violates rule 8";
		reportError(msg, node);
	}
}
