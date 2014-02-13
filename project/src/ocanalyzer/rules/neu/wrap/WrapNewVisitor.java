package ocanalyzer.rules.neu.wrap;

import java.lang.reflect.Modifier;
import java.util.List;
import java.util.Map;

import ocanalyzer.rules.general.ViolationHandler;
import ocanalyzer.rules.general.ViolationHandlerImpl;
import ocanalyzer.rules.r3_8_wrap.determinator.PrimitiveDeterminator;

import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.FieldDeclaration;
import org.eclipse.jdt.core.dom.ITypeBinding;
import org.eclipse.jdt.core.dom.MethodDeclaration;
import org.eclipse.jdt.core.dom.SingleVariableDeclaration;
import org.eclipse.jdt.core.dom.Type;
import org.eclipse.jdt.core.dom.TypeDeclaration;

public class WrapNewVisitor extends ASTVisitor {

	private ViolationHandler handler;
	private Map<TypeDeclaration, Type> wrappers;
	private TypeDeclaration current;

	public WrapNewVisitor(ViolationHandlerImpl handler,
			Map<TypeDeclaration, Type> wrappers) {
		this.handler = handler;
		this.wrappers = wrappers;
	}

	public boolean visit(TypeDeclaration typeDeclaration) {
		current = typeDeclaration;
		return true;
	}

	public void endVisit(FieldDeclaration fieldDeclaration) {
		Type type = fieldDeclaration.getType();
		visitType(type);
	}

	@Override
	public boolean visit(MethodDeclaration node) {
		if (!Modifier.isPrivate(node.getModifiers())) {
			checkParameters(node);
			checkReturn(node);
		}
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
		boolean determineType = determineType(node);
		if (determineType) {
			Type type = wrappers.get(current);
			if (type != null && node != type) {
				handler.printInfo(node);
			}
		}
	}

	private boolean determineType(Type node) {
		if (node != null) {
			ITypeBinding resolveTypeBinding = node.resolveBinding();
			return visitType(resolveTypeBinding);
		}
		return false;
	}

	private boolean visitType(ITypeBinding resolveTypeBinding) {
		if (resolveTypeBinding != null) {
			PrimitiveDeterminator determinator = new PrimitiveDeterminator();
			return determinator.determineType(resolveTypeBinding);
		}
		return false;
	}
}
