package ocanalyzer.rules.wrapPrimitivesAndStrings;

import java.util.Set;

import ocanalyzer.rules.general.ValidationHandler;

import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.MethodInvocation;
import org.eclipse.jdt.core.dom.TypeDeclaration;
import org.eclipse.jdt.core.dom.VariableDeclarationStatement;

public class WrapPrimitiveVisitor extends ASTVisitor {

	private PrimitiveWrapper primitiveWrapper;
	private UseWrapper useWrapper;

	public WrapPrimitiveVisitor(ValidationHandler validatonHandler) {
		primitiveWrapper = new PrimitiveWrapper(validatonHandler);
		Set<TypeDeclaration> wrapperUnits = primitiveWrapper.getWrapperUnits();
		useWrapper = new UseWrapper(validatonHandler, wrapperUnits);
	}

	@Override
	public boolean visit(TypeDeclaration type) {
		boolean prim = primitiveWrapper.visit(type);
		boolean wrapper = useWrapper.visit(type);
		return prim || wrapper;
	}

	@Override
	public boolean visit(VariableDeclarationStatement type) {
		return primitiveWrapper.visit(type);
	}

	@Override
	public void endVisit(TypeDeclaration type) {
		primitiveWrapper.endVisit(type);
	}

	@Override
	public void endVisit(MethodInvocation node) {
		useWrapper.endVisit(node);
	}
}
