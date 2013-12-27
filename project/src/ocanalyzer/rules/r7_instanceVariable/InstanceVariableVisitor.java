package ocanalyzer.rules.r7_instanceVariable;

import ocanalyzer.rules.general.ViolationHandlerImpl;

import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.TypeDeclaration;

public class InstanceVariableVisitor extends ASTVisitor {

	private ViolationHandlerImpl validationHandler;

	private InstanceVariableCounter counter;

	public InstanceVariableVisitor(ViolationHandlerImpl validatonHandler) {
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
