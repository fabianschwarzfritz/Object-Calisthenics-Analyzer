package ocanalyzer.rules.r4_onedot;

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
class DotViolationHandler extends ViolationHandlerImpl {

	private static final String RULENAME = "Rule 4";

	public DotViolationHandler(ICompilationUnit unit,
			CompilationUnit compilationUnit, Reporter reporter) {
		super(unit, compilationUnit, reporter);
	}

	@Override
	public void printInfo(ASTNode node) {
		String msg = "Using more that one dot per line violates rule 4!";
		reportError(RULENAME, msg, node);
	}

	@Override
	public void printInfo(ASTNode type, String customMessage) {
		reportError(RULENAME, customMessage, type);
	}
}
