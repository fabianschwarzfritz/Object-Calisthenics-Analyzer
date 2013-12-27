package ocanalyzer.rules.r3_8_wrap.general;

import java.util.Set;

import ocanalyzer.rules.general.ViolationHandlerImpl;
import ocanalyzer.rules.r3_8_wrap.determinator.TypeDeterminator;

import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.FieldDeclaration;
import org.eclipse.jdt.core.dom.ITypeBinding;
import org.eclipse.jdt.core.dom.Type;
import org.eclipse.jdt.core.dom.TypeDeclaration;
import org.eclipse.jdt.core.dom.VariableDeclarationStatement;

public class UseWrapperVisitor extends ASTVisitor {

	private ViolationHandlerImpl validationHandler;

	private TypeDeclaration visitingType;
	private Set<TypeDeclaration> wrapperUnits;

	private TypeDeterminator determinator;

	public UseWrapperVisitor(ViolationHandlerImpl validatonHandler,
			Set<TypeDeclaration> wrapperUnits, TypeDeterminator determinator) {
		this.validationHandler = validatonHandler;
		this.wrapperUnits = wrapperUnits;
		this.determinator = determinator;
	}

	@Override
	public boolean visit(TypeDeclaration type) {
		visitingType = type;
		return !isWrapper();
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
			if (determinator.determineType(resolveTypeBinding)) {
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
