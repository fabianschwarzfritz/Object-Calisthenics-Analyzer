package ocanalyzer.rules.general;

import ocanalyzer.reporter.ClassReporter;
import ocanalyzer.reporter.ClassViolation;

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
 * {@link ViolationHandlerImpl#printInfo(Statement)} and handles the violation
 * information accordingly. Most implementations add rule specific information
 * and then use either a {@link #reporter} manually or the provided
 * {@link #reportError(String, Statement)} to report a rule violation.
 * 
 * @author Fabian Schwarz-Fritz
 * 
 */
public abstract class ViolationHandlerImpl implements ViolationHandler {

	protected ICompilationUnit unit;
	protected CompilationUnit compilationUnit;
	protected ClassReporter reporter;

	public ViolationHandlerImpl(ICompilationUnit unit,
			CompilationUnit compilationUnit, ClassReporter reporter) {
		super();
		this.unit = unit;
		this.compilationUnit = compilationUnit;
		this.reporter = reporter;
	}

	protected void reportError(String message, ASTNode node) {
		IResource resource = unit.getResource();
		int startPosition = node.getStartPosition();
		int line = compilationUnit.getLineNumber(startPosition);

		reporter.reportError(new ClassViolation(resource, line, message));
	}
}