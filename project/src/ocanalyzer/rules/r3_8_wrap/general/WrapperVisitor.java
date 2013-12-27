package ocanalyzer.rules.r3_8_wrap.general;

import java.util.List;
import java.util.Set;

import ocanalyzer.rules.general.ViolationHandlerImpl;
import ocanalyzer.rules.r3_8_wrap.determinator.TypeDeterminator;
import ocanalyzer.rules.r7_instanceVariable.InstanceVariableCounter;

import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.ITypeBinding;
import org.eclipse.jdt.core.dom.MethodDeclaration;
import org.eclipse.jdt.core.dom.SingleVariableDeclaration;
import org.eclipse.jdt.core.dom.Type;
import org.eclipse.jdt.core.dom.TypeDeclaration;

public class WrapperVisitor extends ASTVisitor {

	private ViolationHandlerImpl validationHandler;

	private TypeDeclaration visitingType;
	private Set<TypeDeclaration> wrapperUnits;

	private TypeDeterminator determinator;

	public WrapperVisitor(ViolationHandlerImpl validatonHandler,
			Set<TypeDeclaration> wrapperUnits, TypeDeterminator determinator) {
		this.validationHandler = validatonHandler;
		this.wrapperUnits = wrapperUnits;
		this.determinator = determinator;
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
			addIfSerachedType(resolveTypeBinding);
		}
	}

	private void addIfSerachedType(ITypeBinding resolveTypeBinding) {
		if (determinator.determineType(resolveTypeBinding)) {
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
