package ocanalyzer.rules.r6_small;

import ocanalyzer.reporter.Reporter;
import ocanalyzer.rules.general.ViolationHandlerImpl;

import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.dom.ASTNode;
import org.eclipse.jdt.core.dom.CompilationUnit;

/**
 * This class handles rule validation.
 * 
 * Therefore it creates corresponding messages for the users and reports them to
 * the given {@link #reporter}
 * 
 * @author Fabian Schwarz-Fritz
 * 
 */
class SmallViolationHandler extends ViolationHandlerImpl {

	public SmallViolationHandler(ICompilationUnit unit,
			CompilationUnit compilationUnit, Reporter reporter) {
		super(unit, compilationUnit, reporter);
	}

	@Override
	public void printInfo(ASTNode node) {
		String msg = "Keep all entities small";
		reportError(msg, node);
	}

	@Override
	public void printInfo(ASTNode type, String customMessage) {
		reportError(customMessage, type);

	}
}
