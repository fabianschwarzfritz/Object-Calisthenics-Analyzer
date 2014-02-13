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
	private TypeDeterminator determinator;
	private TypeDeclaration current;

	public WrapperVisitor(Map<TypeDeclaration, Type> wrapperUnits,
			TypeDeterminator determinator) {
		this.wrapperUnits = wrapperUnits;
		this.determinator = determinator;
	}

	public boolean visit(TypeDeclaration node) {
		current = node;
		return true;
	}

	@Override
	public void endVisit(FieldDeclaration node) {
		Type type = node.getType();
		ITypeBinding binding = type.resolveBinding();
		boolean isPrimitive = determinator.determineType(binding);
		if (isPrimitive) {
			String typeName = binding.getName();
			System.out.println("Will add: " + typeName);
			// TODO prevent overwriting if clas { private int a; private String
			// string --> the first value counts!
			if (!wrapperUnits.containsKey(current)) {
				wrapperUnits.put(current, type);
			}
		}
	}
}
