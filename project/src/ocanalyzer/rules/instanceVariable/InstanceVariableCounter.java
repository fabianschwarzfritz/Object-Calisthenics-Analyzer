package ocanalyzer.rules.instanceVariable;

import org.eclipse.jdt.core.dom.FieldDeclaration;
import org.eclipse.jdt.core.dom.Modifier;
import org.eclipse.jdt.core.dom.TypeDeclaration;
import org.eclipse.jdt.core.dom.VariableDeclarationFragment;

public class InstanceVariableCounter {

	private int resultCount;
	private TypeDeclaration type;

	public InstanceVariableCounter(TypeDeclaration type) {
		this.type = type;
		reset();
	}

	private void reset() {
		resultCount = 0;
	}

	public int instanceVariableCount() {
		reset();

		FieldDeclaration[] fields = type.getFields();

		for (int i = 0; i < fields.length; i++) {
			VariableDeclarationFragment node = (VariableDeclarationFragment) fields[i]
					.fragments().get(0);
			countVariable(node);
		}
		return resultCount;
	}

	private void countVariable(VariableDeclarationFragment node) {
		if (node.getParent() instanceof FieldDeclaration) {
			int modifiers = ((FieldDeclaration) node.getParent())
					.getModifiers();
			countInstanceVariable(modifiers);
		}
	}

	private void countInstanceVariable(int modifiers) {
		if (!Modifier.isStatic(modifiers)) {
			resultCount++;
		}
	}
}
