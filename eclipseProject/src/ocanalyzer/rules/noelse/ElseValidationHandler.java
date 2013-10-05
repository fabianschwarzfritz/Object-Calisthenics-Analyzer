package ocanalyzer.rules.noelse;

import java.io.PrintStream;

import ocanalyzer.reporter.MyReporter;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
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
public class ElseValidationHandler {

	private ICompilationUnit unit;
	private CompilationUnit compilationUnit;

	private MyReporter reporter;

	public ElseValidationHandler(ICompilationUnit unit,
			CompilationUnit compilationUnit, MyReporter reporter) {
		super();
		this.unit = unit;
		this.compilationUnit = compilationUnit;
		this.reporter = reporter;
	}

	public void printElseInfo(PrintStream stream, Statement elseStatements) {
		IResource resource = unit.getResource();
		int line = compilationUnit.getLineNumber(elseStatements
				.getStartPosition());
		String msg = "The else keyword violates rule 2";

		try {
			reporter.reportError(resource, line, msg);
		} catch (CoreException e) {
			e.printStackTrace();
		}
	}
}
