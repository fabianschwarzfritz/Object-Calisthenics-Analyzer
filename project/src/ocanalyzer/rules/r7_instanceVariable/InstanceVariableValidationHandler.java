package ocanalyzer.rules.r7_instanceVariable;

import ocanalyzer.reporter.ClassReporter;
import ocanalyzer.rules.general.ValidationHandlerImpl;

import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.dom.ASTNode;
import org.eclipse.jdt.core.dom.CompilationUnit;

public class InstanceVariableValidationHandler extends ValidationHandlerImpl {

	public InstanceVariableValidationHandler(ICompilationUnit unit,
			CompilationUnit compilationUnit, ClassReporter reporter) {
		super(unit, compilationUnit, reporter);
	}

	@Override
	public void printInfo(ASTNode node) {
		String msg = "More than two instance variables. That violates rule 7!";
		reportError(msg, node);
	}
}
