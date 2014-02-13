package ocanalyzer.rules.neu.wrap;

import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.dom.ASTNode;
import org.eclipse.jdt.core.dom.CompilationUnit;

import ocanalyzer.reporter.ClassReporter;
import ocanalyzer.rules.general.ViolationHandlerImpl;

public class WrapNewViolationHandler extends ViolationHandlerImpl {

	public WrapNewViolationHandler(ICompilationUnit unit,
			CompilationUnit compilationUnit, ClassReporter reporter) {
		super(unit, compilationUnit, reporter);
	}

	@Override
	public void printInfo(ASTNode node) {
		String msg = "Wrap all primitives!";
		reportError(msg, node);
	}

}
