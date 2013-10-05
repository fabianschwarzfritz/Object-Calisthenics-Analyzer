package ocanalyzer.rules.indentation;

import ocanalyzer.reporter.MyReporter;
import ocanalyzer.rules.ValidationHandler;

import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.Statement;

public class IndentationValidationHandler extends ValidationHandler {

	public IndentationValidationHandler(ICompilationUnit unit,
			CompilationUnit compilationUnit, MyReporter reporter) {
		super(unit, compilationUnit, reporter);
	}

	@Override
	public void printInfo(Statement statement) {
		String msg = "The intention violates rule 1";
		reportError(msg, statement);
	}

}
