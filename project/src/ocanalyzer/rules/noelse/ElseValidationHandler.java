package ocanalyzer.rules.noelse;

import ocanalyzer.reporter.RuleViolationReporter;
import ocanalyzer.rules.ValidationHandler;

import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.Statement;

/**
 * This class handles rule validation.
 * 
 * Therefore it creates corresponding messages for the users and reports them to
 * the given {@link #reporter}
 * 
 * @author Fabian Schwarz-Fritz
 * 
 */
public class ElseValidationHandler extends ValidationHandler {

	public ElseValidationHandler(ICompilationUnit unit,
			CompilationUnit compilationUnit, RuleViolationReporter reporter) {
		super(unit, compilationUnit, reporter);
	}

	@Override
	public void printInfo(Statement statement) {
		String msg = "The else keyword violates rule 2";
		reportError(msg, statement);
	}
}
