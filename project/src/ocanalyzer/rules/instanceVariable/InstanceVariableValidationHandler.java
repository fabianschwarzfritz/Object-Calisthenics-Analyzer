package ocanalyzer.rules.instanceVariable;

import ocanalyzer.reporter.Reporter;
import ocanalyzer.rules.general.ValidationHandler;

import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.dom.ASTNode;
import org.eclipse.jdt.core.dom.CompilationUnit;

public class InstanceVariableValidationHandler extends ValidationHandler {

	public InstanceVariableValidationHandler(ICompilationUnit unit,
			CompilationUnit compilationUnit, Reporter reporter) {
		super(unit, compilationUnit, reporter);
	}

	@Override
	public void printInfo(ASTNode node) {
		String msg = "More than two instance variables. That violates rule 7!";
		reportError(msg, node);
	}
}
