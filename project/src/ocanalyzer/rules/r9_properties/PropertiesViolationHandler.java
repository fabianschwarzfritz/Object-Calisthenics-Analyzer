package ocanalyzer.rules.r9_properties;

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
class PropertiesViolationHandler extends ViolationHandlerImpl {

	private static final String RULENAME = "Rule 9";

	public PropertiesViolationHandler(ICompilationUnit unit,
			CompilationUnit compilationUnit, Reporter reporter) {
		super(unit, compilationUnit, reporter);
	}

	@Override
	public void printInfo(ASTNode node) {
		String msg = "The use of getter/setter/properties violates rule 9";
		reportError(RULENAME, msg, node);
	}

	@Override
	public void printInfo(ASTNode type, String customMessage) {
		reportError(RULENAME, customMessage, type);
	}
}
