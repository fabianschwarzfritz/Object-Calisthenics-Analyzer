package ocanalyzer.rules.neu.wrap;

import java.util.HashMap;
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
	private TypeDeclaration currentDeclaration;

	private TypeDeterminator typeDeterminator;

	private WrapNewViolationHandler violationHandler;

	public WrapperVisitor(TypeDeterminator determinator,
			WrapNewViolationHandler violationHandler) {
		this.typeDeterminator = determinator;
		this.violationHandler = violationHandler;
		wrapperUnits = new HashMap<>();
		nonWrapperUnits = new HashMap<TypeDeclaration, Type>();
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
		if (isPrimitive) {
			addWrapper(type);
			return;
		}
		addNonWrapper(type);
	}

	private void addNonWrapper(Type type) {
		nonWrapperUnits.put(currentDeclaration, type);
	}

	private void addWrapper(Type type) {
		// ifCurrentNoWrapper(type);
		ifAlreadyContainsDifferentType(type);
		addIfNew(type);
	}

	// private void ifCurrentNoWrapper(Type type) {
	// if (nonWrapperUnits.containsKey(currentDeclaration)) {
	// violationHandler
	// .printInfo(
	// type,
	// "The current type is not a wrapper type. Extract this variable to satisfy rule 3!");
	// System.out
	// .println("In "
	// + currentDeclaration.getName()
	// + ": "
	// + "Type "
	// + type
	// +
	// ": The current type is not a wrapper type. Extract this variable to satisfy rule 3!");
	// }
	// }

	private void ifAlreadyContainsDifferentType(Type type) {
		if (isWrapperUnit(currentDeclaration)
				&& !typesEqual(wrapperUnits.get(currentDeclaration), type)) {
			violationHandler.printInfo(type, "This (" + type
					+ ") is already a wrapper for another type ("
					+ wrapperUnits.get(currentDeclaration)
					+ ")! Extract this to satisfy rule 3!");
			System.out
					.println("Type "
							+ type
							+ "In "
							+ currentDeclaration.getName()
							+ ": "
							+ ": This is already a wrapper for another type! Extract this to satisfy rule 3!");
		}
	}

	private void addIfNew(Type type) {
		if (!isWrapperUnit(currentDeclaration)) {
			wrapperUnits.put(currentDeclaration, type);
			System.out.println("In " + currentDeclaration.getName() + ": "
					+ "Type " + type + " is now in wrapper units");
		}
	}

	private boolean isWrapperUnit(TypeDeclaration declaration) {
		return wrapperUnits.containsKey(currentDeclaration);
	}

	private boolean typesEqual(Type typeOne, Type typeTwo) {
		ITypeBinding resolveOne = typeOne.resolveBinding();
		ITypeBinding resolveTwo = typeTwo.resolveBinding();
		String nameOne = resolveOne.getName();
		String nameTwo = resolveTwo.getName();
		return nameOne.equals(nameTwo);
	}

	public Map<TypeDeclaration, Type> wrapperUnits() {
		return new HashMap<>(wrapperUnits);
	}
}
