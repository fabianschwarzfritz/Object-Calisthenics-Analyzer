package ocanalyzer.rules.wrapPrimitivesAndStrings.useWrappers;

import java.util.List;
import java.util.Set;

import ocanalyzer.rules.general.ValidationHandler;
import ocanalyzer.rules.wrapPrimitivesAndStrings.PrimitiveDeterminator;

import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.FieldDeclaration;
import org.eclipse.jdt.core.dom.ITypeBinding;
import org.eclipse.jdt.core.dom.MethodDeclaration;
import org.eclipse.jdt.core.dom.SingleVariableDeclaration;
import org.eclipse.jdt.core.dom.Type;
import org.eclipse.jdt.core.dom.TypeDeclaration;
import org.eclipse.jdt.core.dom.VariableDeclarationStatement;

public class UseWrapperVisitor extends ASTVisitor {

	private ValidationHandler validationHandler;

	private TypeDeclaration visitingType;
	private Set<TypeDeclaration> wrapperUnits;

	public UseWrapperVisitor(ValidationHandler validatonHandler,
			Set<TypeDeclaration> wrapperUnits) {
		this.validationHandler = validatonHandler;
		this.wrapperUnits = wrapperUnits;
	}

	@Override
	public boolean visit(TypeDeclaration type) {
		visitingType = type;
		return !isWrapper();
	}

	@Override
	public boolean visit(MethodDeclaration node) {
		@SuppressWarnings("unchecked")
		List<SingleVariableDeclaration> parameters = node.parameters();
		for (SingleVariableDeclaration declaration : parameters) {
			Type type = declaration.getType();
			visitType(type);
		}
		return true;

	}

	@Override
	public boolean visit(FieldDeclaration node) {
		visitType(node.getType());
		return true;
	}

	@Override
	public boolean visit(VariableDeclarationStatement node) {
		visitType(node.getType());
		return true;
	}

	private void visitType(Type node) {
		if (!isWrapper()) {
			ITypeBinding resolveTypeBinding = node.resolveBinding();
			PrimitiveDeterminator primitiveDeterminator = new PrimitiveDeterminator();
			if (primitiveDeterminator.isPrimitive(resolveTypeBinding)) {
				validationHandler.printInfo(node);
			}
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
