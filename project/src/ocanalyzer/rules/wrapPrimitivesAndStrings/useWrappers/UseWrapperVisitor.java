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

	private Set<TypeDeclaration> wrapperUnits;

	public UseWrapperVisitor(ValidationHandler validatonHandler,
			Set<TypeDeclaration> wrapperUnits) {
		this.validationHandler = validatonHandler;
		this.wrapperUnits = wrapperUnits;
	}

	@Override
	public boolean visit(TypeDeclaration type) {
		return !isWrapper(type);
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
		return visitType(node.getType());
	}

	@Override
	public boolean visit(VariableDeclarationStatement node) {
		return visitType(node.getType());
	}

	private boolean visitType(Type node) {
		ITypeBinding resolveTypeBinding = node.resolveBinding();
		PrimitiveDeterminator primitiveDeterminator = new PrimitiveDeterminator();
		if (primitiveDeterminator.isPrimitive(resolveTypeBinding)) {
			validationHandler.printInfo(node);
		}
		return true;
	}

	private boolean isWrapper(TypeDeclaration type) {
		return wrapperUnits.contains(type);
	}

}
