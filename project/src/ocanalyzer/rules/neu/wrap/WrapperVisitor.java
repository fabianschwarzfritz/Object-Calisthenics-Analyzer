package ocanalyzer.rules.neu.wrap;

import java.util.Map;

import ocanalyzer.rules.r3_8_wrap.determinator.TypeDeterminator;

import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.FieldDeclaration;
import org.eclipse.jdt.core.dom.ITypeBinding;
import org.eclipse.jdt.core.dom.Type;
import org.eclipse.jdt.core.dom.TypeDeclaration;

public class WrapperVisitor extends ASTVisitor {

	private Map<TypeDeclaration, Type> wrapperUnits;
	private Map<TypeDeclaration, Type> nonWrapperUnits;
	private TypeDeterminator typeDeterminator;
	private TypeDeclaration currentDeclaration;
	private WrapNewViolationHandler violationHandler;

	public WrapperVisitor(Map<TypeDeclaration, Type> wrapperUnits,
			TypeDeterminator determinator,
			WrapNewViolationHandler violationHandler) {
		this.wrapperUnits = wrapperUnits;
		this.typeDeterminator = determinator;
		this.violationHandler = violationHandler;
	}

	public boolean visit(TypeDeclaration node) {
		currentDeclaration = node;
		return true;
	}

	@Override
	public void endVisit(FieldDeclaration node) {
		Type type = node.getType();
		ITypeBinding binding = type.resolveBinding();
		boolean isPrimitive = typeDeterminator.determineType(binding);
		if (!isPrimitive) {
			addNonWrapper(type);
			return;
		}
		String typeName = binding.getName();
		System.out.println("Will add: " + typeName);
		// TODO prevent overwriting if class { private int a; private String
		// string --> the first value counts!
		addWrapper(type);
	}

	private void addNonWrapper(Type type) {
		nonWrapperUnits.put(currentDeclaration, type);
	}

	private void addWrapper(Type type) {
		if (nonWrapperUnits.containsKey(currentDeclaration)) {
			violationHandler.printInfo(type,
					"This is not a wrapper type. Extract this variable!");
		}
		if (wrapperUnits.containsKey(currentDeclaration)
				&& wrapperUnits.get(currentDeclaration).equals(type)) {
			violationHandler.printInfo(type,
					"This is already a wrapper for another class!");
		}
		if (!wrapperUnits.containsKey(currentDeclaration)) {
			wrapperUnits.put(currentDeclaration, type);
		}
	}
}
