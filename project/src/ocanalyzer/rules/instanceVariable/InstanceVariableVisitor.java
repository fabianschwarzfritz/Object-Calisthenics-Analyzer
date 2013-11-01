package ocanalyzer.rules.instanceVariable;

import ocanalyzer.rules.general.ValidationHandler;

import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.CompilationUnit;

public class InstanceVariableVisitor extends ASTVisitor {

	private ValidationHandler validationHandler;

	public InstanceVariableVisitor(ValidationHandler validatonHandler) {
		this.validationHandler = validatonHandler;
	}

	@Override
	public void endVisit(CompilationUnit node) {

	}

}
