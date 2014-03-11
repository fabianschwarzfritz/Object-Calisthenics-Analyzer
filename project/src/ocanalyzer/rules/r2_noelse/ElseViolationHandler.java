package ocanalyzer.rules.r2_noelse;

import ocanalyzer.reporter.Reporter;
import ocanalyzer.rules.general.ViolationHandlerImpl;

import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.dom.ASTNode;
import org.eclipse.jdt.core.dom.CompilationUnit;

/**
 * This class handles rule validation of rule 2: "Do not use the else keyword".
 * 
 * Therefore it creates corresponding messages for the users and reports them to
 * the given {@link #reporter}
 * 
 * @author Fabian Schwarz-Fritz
 * 
 */
class ElseViolationHandler extends ViolationHandlerImpl {
	
	private static final String RULENAME = "Rule 2";

	public ElseViolationHandler(ICompilationUnit unit,
			CompilationUnit compilationUnit, Reporter reporter) {
		super(unit, compilationUnit, reporter);
	}

	@Override
	public void printInfo(ASTNode node) {
		String msg = "The else keyword violates rule 2";
		reportError(RULENAME, msg, node);
	}

	@Override
	public void printInfo(ASTNode type, String customMessage) {
		reportError(RULENAME, customMessage, type);
	}
}
