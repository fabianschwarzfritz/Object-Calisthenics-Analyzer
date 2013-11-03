package ocanalyzer.rules.wrapPrimitivesAndStrings.wrapperTypes;

import java.util.Set;

import ocanalyzer.rules.general.ValidationHandler;
import ocanalyzer.rules.instanceVariable.InstanceVariableCounter;
import ocanalyzer.rules.wrapPrimitivesAndStrings.PrimitiveDeterminator;

import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.FieldDeclaration;
import org.eclipse.jdt.core.dom.ITypeBinding;
import org.eclipse.jdt.core.dom.Name;
import org.eclipse.jdt.core.dom.SimpleType;
import org.eclipse.jdt.core.dom.Type;
import org.eclipse.jdt.core.dom.TypeDeclaration;
import org.eclipse.jdt.core.dom.VariableDeclarationStatement;

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
	public boolean visit(FieldDeclaration node) {
		return visitType(node.getType());
	}

	@Override
	public boolean visit(VariableDeclarationStatement node) {
		return visitType(node.getType());
	}

	private boolean visitType(Type node) {
		add(node);
		return true;
	}

	private void add(Type type) {
		try {
			// SimpleType simpleType = (SimpleType) type;
			// Name name = simpleType.getName();
			// ITypeBinding resolveTypeBinding = name.resolveTypeBinding();
			addWrapper(type.resolveBinding());
		} catch (ClassCastException e) {
		}
	}

	private void addWrapper(ITypeBinding resolveTypeBinding) {
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
