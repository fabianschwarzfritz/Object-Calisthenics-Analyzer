package ocanalyzer.rules.instanceVariable;

import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.FieldDeclaration;
import org.eclipse.jdt.core.dom.Modifier;
import org.eclipse.jdt.core.dom.TypeDeclaration;
import org.eclipse.jdt.core.dom.VariableDeclarationFragment;

public class InstanceVariableCounter {

	private int resultCount;
	private CompilationUnit unit;

	public InstanceVariableCounter(CompilationUnit unit) {
		this.unit = unit;
		reset();
	}

	private void reset() {
		resultCount = 0;
	}

	public int instanceVariableCount() {
		reset();

		TypeDeclaration type = (TypeDeclaration) unit.types().get(0);
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
