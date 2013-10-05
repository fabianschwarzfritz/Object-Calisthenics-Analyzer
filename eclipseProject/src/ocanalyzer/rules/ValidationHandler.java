package ocanalyzer.rules;

import ocanalyzer.reporter.RuleViolationReporter;

import org.eclipse.core.resources.IResource;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.Statement;

public abstract class ValidationHandler {

	protected ICompilationUnit unit;
	protected CompilationUnit compilationUnit;
	protected RuleViolationReporter reporter;

	public ValidationHandler(ICompilationUnit unit,
			CompilationUnit compilationUnit, RuleViolationReporter reporter) {
		super();
		this.unit = unit;
		this.compilationUnit = compilationUnit;
		this.reporter = reporter;
	}

	public abstract void printInfo(Statement statement);

	protected void reportError(String message, Statement statement) {
		IResource resource = unit.getResource();
		int startPosition = statement.getStartPosition();
		int line = compilationUnit.getLineNumber(startPosition);

		reporter.reportError(resource, line, message);
	}
}