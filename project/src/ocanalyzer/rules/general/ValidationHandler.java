package ocanalyzer.rules.general;

import ocanalyzer.reporter.Reporter;
import ocanalyzer.reporter.Violation;

import org.eclipse.core.resources.IResource;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.dom.ASTNode;
import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.Statement;

/**
 * This class abstract the behaviour what to do when a rule violation is found
 * by a concrete {@link ASTVisitor}
 * 
 * Therefore a concrete handler overrides
 * {@link ValidationHandler#printInfo(Statement)} and handles the violation
 * information accordingly. Most implementations add rule specific information
 * and then use either a {@link #reporter} manually or the provided
 * {@link #reportError(String, Statement)} to report a rule violation.
 * 
 * @author Fabian Schwarz-Fritz
 * 
 */
public abstract class ValidationHandler {

	protected ICompilationUnit unit;
	protected CompilationUnit compilationUnit;
	protected Reporter reporter;

	public ValidationHandler(ICompilationUnit unit,
			CompilationUnit compilationUnit, Reporter reporter) {
		super();
		this.unit = unit;
		this.compilationUnit = compilationUnit;
		this.reporter = reporter;
	}

	public abstract void printInfo(ASTNode node);

	protected void reportError(String message, ASTNode node) {
		IResource resource = unit.getResource();
		int startPosition = node.getStartPosition();
		int line = compilationUnit.getLineNumber(startPosition);

		reporter.reportError(new Violation(resource, line, message));
	}
}
