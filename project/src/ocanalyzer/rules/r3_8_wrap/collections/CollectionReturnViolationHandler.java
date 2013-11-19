package ocanalyzer.rules.r3_8_wrap.collections;

import ocanalyzer.reporter.Reporter;
import ocanalyzer.rules.general.ValidationHandler;

import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.dom.ASTNode;
import org.eclipse.jdt.core.dom.CompilationUnit;

public class CollectionReturnViolationHandler extends ValidationHandler {

	public CollectionReturnViolationHandler(ICompilationUnit unit,
			CompilationUnit compilationUnit, Reporter reporter) {
		super(unit, compilationUnit, reporter);
	}

	@Override
	public void printInfo(ASTNode node) {
		String msg = "Returning a collection type in a wrapper classes violates rule 3";
		reportError(msg, node);
	}
}
