package ocanalyzer.rules.r38_wrap;

import ocanalyzer.reporter.ClassReporter;
import ocanalyzer.rules.general.ViolationHandlerImpl;

import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.dom.ASTNode;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.Type;

public class WrapNewViolationHandler extends ViolationHandlerImpl {

	private static final String baseMessage = "Wrap all this!";

	public WrapNewViolationHandler(ICompilationUnit unit,
			CompilationUnit compilationUnit, ClassReporter reporter) {
		super(unit, compilationUnit, reporter);
	}

	@Override
	public void printInfo(ASTNode node) {
		reportError(baseMessage, node);
	}

	public void printInfo(ASTNode node, String individualMessage) {
		reportError(baseMessage + " " + individualMessage, node);
	}

}
