package ocanalyzer.rules.wrapPrimitivesAndStrings;

import java.util.Set;

import ocanalyzer.rules.general.ValidationHandler;

import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.IMethodBinding;
import org.eclipse.jdt.core.dom.ITypeBinding;
import org.eclipse.jdt.core.dom.MethodInvocation;
import org.eclipse.jdt.core.dom.TypeDeclaration;

public class UseWrapper extends ASTVisitor {

	private ValidationHandler validationHandler;

	private TypeDeclaration visitingType;
	private Set<TypeDeclaration> wrapperUnits;

	public UseWrapper(ValidationHandler validatonHandler,
			Set<TypeDeclaration> wrapperUnits) {
		this.validationHandler = validatonHandler;
		this.wrapperUnits = wrapperUnits;
	}

	@Override
	public boolean visit(TypeDeclaration type) {
		visitingType = type;
		return !wrapperUnits.contains(type);
	}

	@Override
	public void endVisit(MethodInvocation node) {
		IMethodBinding resolveMethodBinding = node.resolveMethodBinding();
		ITypeBinding[] parameterTypes = resolveMethodBinding
				.getParameterTypes();
		boolean hasPrimitive = false;
		PrimitiveDeterminator primitiveDeterminator = new PrimitiveDeterminator();
		for (ITypeBinding iTypeBinding : parameterTypes) {
			hasPrimitive = primitiveDeterminator.isPrimitive(iTypeBinding);
		}
		// Primitive has to be part of a primitive unit
		if (hasPrimitive & !wrapperUnits.contains(visitingType)) {
			validationHandler.printInfo(node);
		}
	}

}
