package ocanalyzer.rules.instanceVariable;

import ocanalyzer.rules.general.ValidationHandler;

import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.TypeDeclaration;

public class InstanceVariableVisitor extends ASTVisitor {

	private ValidationHandler validationHandler;

	private InstanceVariableCounter counter;

	public InstanceVariableVisitor(ValidationHandler validatonHandler) {
		this.validationHandler = validatonHandler;
	}

	@Override
	public boolean visit(TypeDeclaration type) {
		counter = new InstanceVariableCounter(type);
		int instanceVariableCount = counter.instanceVariableCount();
		if (instanceVariableCount > 2) {
			validationHandler.printInfo(type);
		}
		return true;
	}

}
