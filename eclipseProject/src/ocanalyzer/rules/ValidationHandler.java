package ocanalyzer.rules;

import ocanalyzer.reporter.MyReporter;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.Statement;

public abstract class ValidationHandler {

	protected ICompilationUnit unit;
	protected CompilationUnit compilationUnit;
	protected MyReporter reporter;

	public ValidationHandler(ICompilationUnit unit,
			CompilationUnit compilationUnit, MyReporter reporter) {
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
		String msg = "The else keyword violates rule 2";

		try {
			reporter.reportError(resource, line, msg);
		} catch (CoreException e) {
			e.printStackTrace();
		}
	}
}