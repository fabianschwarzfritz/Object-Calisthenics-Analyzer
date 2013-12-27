package ocanalyzer.rules.r3_8_wrap.general;

import java.util.Set;

import ocanalyzer.rules.general.ViolationHandlerImpl;
import ocanalyzer.rules.r3_8_wrap.determinator.TypeDeterminator;

import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.ITypeBinding;
import org.eclipse.jdt.core.dom.MethodDeclaration;
import org.eclipse.jdt.core.dom.Type;
import org.eclipse.jdt.core.dom.TypeDeclaration;

public class ReturnVisitor extends ASTVisitor {

	private ViolationHandlerImpl validationHandler;

	private TypeDeterminator determinator;

	private TypeDeclaration visitingType;
	private Set<TypeDeclaration> wrapperUnits;

	public ReturnVisitor(ViolationHandlerImpl validatonHandler,
			Set<TypeDeclaration> wrapperUnits, TypeDeterminator determinator) {
		this.validationHandler = validatonHandler;
		this.wrapperUnits = wrapperUnits;
		this.determinator = determinator;
	}

	@Override
	public boolean visit(TypeDeclaration type) {
		visitingType = type;
		return isWrapper();
	}

	@Override
	public boolean visit(MethodDeclaration node) {
		checkReturn(node);
		return true;
	}

	private void checkReturn(MethodDeclaration node) {
		Type returnType = node.getReturnType2();
		visitType(returnType);
	}

	private void visitType(Type node) {
		if (isWrapper() & node != null) {
			ITypeBinding resolveTypeBinding = node.resolveBinding();
			visitType(node, resolveTypeBinding);
		}
	}

	private void visitType(Type returnType, ITypeBinding resolveTypeBinding) {
		if (resolveTypeBinding != null) {
			addIfSerachedType(returnType, resolveTypeBinding);
		}
	}

	private void addIfSerachedType(Type type, ITypeBinding resolveTypeBinding) {
		if (determinator.determineType(resolveTypeBinding)) {
			validationHandler.printInfo(type);
		}
	}

	private boolean isWrapper() {
		for (TypeDeclaration wrapper : wrapperUnits) {
			if (wrapper.getName().toString()
					.equals(visitingType.getName().toString())) {
				return true;
			}
		}
		return false;
	}
}
