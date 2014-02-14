package ocanalyzer.rules.r7_instanceVariable;

import ocanalyzer.rules.general.ViolationHandler;
import ocanalyzer.rules.general.ViolationHandlerImpl;

import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.TypeDeclaration;

class InstanceVariableVisitor extends ASTVisitor {

	private ViolationHandler violationHandler;

	private InstanceVariableCounter counter;

	public InstanceVariableVisitor(ViolationHandler violationHandler) {
		this.violationHandler = violationHandler;
	}

	@Override
	public boolean visit(TypeDeclaration type) {
		counter = new InstanceVariableCounter(type);
		int instanceVariableCount = counter.instanceVariableCount();
		if (instanceVariableCount > 2) {
			violationHandler.printInfo(type);
		}
		return true;
	}

}
