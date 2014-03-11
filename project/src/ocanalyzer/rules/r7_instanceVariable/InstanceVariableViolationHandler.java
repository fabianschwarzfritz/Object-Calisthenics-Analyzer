package ocanalyzer.rules.r7_instanceVariable;

import ocanalyzer.reporter.Reporter;
import ocanalyzer.rules.general.ViolationHandlerImpl;

import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.dom.ASTNode;
import org.eclipse.jdt.core.dom.CompilationUnit;

class InstanceVariableViolationHandler extends ViolationHandlerImpl {
	
	private static final String RULENAME = "Rule 7";

	public InstanceVariableViolationHandler(ICompilationUnit unit,
			CompilationUnit compilationUnit, Reporter reporter) {
		super(unit, compilationUnit, reporter);
	}

	@Override
	public void printInfo(ASTNode node) {
		String msg = "More than two instance variables. That violates rule 7!";
		reportError(RULENAME, msg, node);
	}

	@Override
	public void printInfo(ASTNode type, String customMessage) {
		reportError(RULENAME, customMessage, type);
	}
}
