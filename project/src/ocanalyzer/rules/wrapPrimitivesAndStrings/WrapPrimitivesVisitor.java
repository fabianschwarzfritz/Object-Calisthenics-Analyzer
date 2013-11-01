package ocanalyzer.rules.wrapPrimitivesAndStrings;

import java.util.HashSet;
import java.util.Set;

import ocanalyzer.rules.general.ValidationHandler;

import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.ITypeBinding;
import org.eclipse.jdt.core.dom.Name;
import org.eclipse.jdt.core.dom.SimpleType;
import org.eclipse.jdt.core.dom.Type;
import org.eclipse.jdt.core.dom.VariableDeclarationStatement;

public class WrapPrimitivesVisitor extends ASTVisitor {

	private ValidationHandler validationHandler;

	private CompilationUnit visitingUnit;
	private Set<CompilationUnit> wrapperUnits;

	public WrapPrimitivesVisitor(ValidationHandler validatonHandler) {
		this.validationHandler = validatonHandler;
		wrapperUnits = new HashSet<CompilationUnit>();
	}

	@Override
	public boolean visit(CompilationUnit node) {
		visitingUnit = node;
		return true;
	}

	@Override
	public boolean visit(VariableDeclarationStatement node) {
		Type type = node.getType();
		add(type);
		return true;
	}

	private void add(Type type) {
		try {
			SimpleType simpleType = (SimpleType) type;
			Name name = simpleType.getName();
			ITypeBinding resolveTypeBinding = name.resolveTypeBinding();
			addWrapper(resolveTypeBinding);
		} catch (ClassCastException e) {
		}
	}

	private void addWrapper(ITypeBinding resolveTypeBinding) {
		boolean primitive = resolveTypeBinding.isPrimitive();
		boolean string = resolveTypeBinding.getName().equals("String");
		if (primitive | string) {
			wrapperUnits.add(visitingUnit);
		}
	}

	@Override
	public void endVisit(CompilationUnit node) {
		boolean isWrapper = wrapperUnits.contains(node);
		/*
		 * TODO check for wrapper properties: - Has only one instance variable
		 * This could to the visitor that implements
		 * "only two instance variables": Implement with configurable amount of
		 * instance variables
		 */
	}

}
