package ocanalyzer.rules.r38_wrap;

import ocanalyzer.reporter.Reporter;
import ocanalyzer.rules.general.ViolationHandlerImpl;

import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.dom.ASTNode;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.Type;

public class WrapNewViolationHandler extends ViolationHandlerImpl {

	private static final String RULENAME = "Rule 3 or 8";
	private static final String baseMessage = "Wrap all this!";

	public WrapNewViolationHandler(ICompilationUnit unit,
			CompilationUnit compilationUnit, Reporter reporter) {
		super(unit, compilationUnit, reporter);
	}

	@Override
	public void printInfo(ASTNode node) {
		reportError(RULENAME, baseMessage, node);
	}

	public void printInfo(ASTNode node, String individualMessage) {
		reportError(RULENAME, baseMessage + " " + individualMessage, node);
	}

}
