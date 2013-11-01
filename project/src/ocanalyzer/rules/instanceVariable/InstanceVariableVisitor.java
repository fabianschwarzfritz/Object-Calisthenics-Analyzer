package ocanalyzer.rules.instanceVariable;

import ocanalyzer.rules.general.ValidationHandler;

import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.CompilationUnit;

public class InstanceVariableVisitor extends ASTVisitor {

	private ValidationHandler validationHandler;

	private InstanceVariableCounter counter;

	public InstanceVariableVisitor(ValidationHandler validatonHandler) {
		this.validationHandler = validatonHandler;
	}

	@Override
	public boolean visit(CompilationUnit node) {
		counter = new InstanceVariableCounter(node);
		int instanceVariableCount = counter.instanceVariableCount();
		if (instanceVariableCount > 2) {
			// TODO report violation
		}
		return true;
	}
}
