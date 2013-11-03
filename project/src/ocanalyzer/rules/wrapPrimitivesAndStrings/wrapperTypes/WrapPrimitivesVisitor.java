package ocanalyzer.rules.wrapPrimitivesAndStrings.wrapperTypes;

import java.util.List;
import java.util.Set;

import ocanalyzer.rules.general.ValidationHandler;
import ocanalyzer.rules.instanceVariable.InstanceVariableCounter;
import ocanalyzer.rules.wrapPrimitivesAndStrings.PrimitiveDeterminator;

import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.ITypeBinding;
import org.eclipse.jdt.core.dom.MethodDeclaration;
import org.eclipse.jdt.core.dom.SingleVariableDeclaration;
import org.eclipse.jdt.core.dom.Type;
import org.eclipse.jdt.core.dom.TypeDeclaration;

public class WrapPrimitivesVisitor extends ASTVisitor {

	private ValidationHandler validationHandler;

	private TypeDeclaration visitingType;
	private Set<TypeDeclaration> wrapperUnits;

	public WrapPrimitivesVisitor(ValidationHandler validatonHandler,
			Set<TypeDeclaration> wrapperUnits) {
		this.validationHandler = validatonHandler;
		this.wrapperUnits = wrapperUnits;
	}

	@Override
	public boolean visit(TypeDeclaration type) {
		visitingType = type;
		return true;
	}

	@Override
	public boolean visit(MethodDeclaration node) {
		checkParameters(node);
		checkReturn(node);
		return true;

	}

	private void checkParameters(MethodDeclaration node) {
		@SuppressWarnings("unchecked")
		List<SingleVariableDeclaration> parameters = node.parameters();
		for (SingleVariableDeclaration declaration : parameters) {
			Type type = declaration.getType();
			visitType(type);
		}
	}

	private void checkReturn(MethodDeclaration node) {
		Type returnType = node.getReturnType2();
		visitType(returnType);
	}

	private void visitType(Type node) {
		if (node != null) {
			ITypeBinding resolveTypeBinding = node.resolveBinding();

			visitType(resolveTypeBinding);
		}
	}

	private void visitType(ITypeBinding resolveTypeBinding) {
		if (resolveTypeBinding != null) {
			addIfPrimitive(resolveTypeBinding);
		}
	}

	private void addIfPrimitive(ITypeBinding resolveTypeBinding) {
		PrimitiveDeterminator primitiveDeterminator = new PrimitiveDeterminator();
		if (primitiveDeterminator.isPrimitive(resolveTypeBinding)) {
			wrapperUnits.add(visitingType);
		}
	}

	@Override
	public void endVisit(TypeDeclaration type) {
		boolean isWrapper = wrapperUnits.contains(type);
		if (isWrapper) {
			ensureWrapper(type);
		}
	}

	private void ensureWrapper(TypeDeclaration type) {
		InstanceVariableCounter counter = new InstanceVariableCounter(
				visitingType);
		int instanceVariableCount = counter.instanceVariableCount();
		if (instanceVariableCount > 1) {
			validationHandler.printInfo(type);
		}
	}

}
