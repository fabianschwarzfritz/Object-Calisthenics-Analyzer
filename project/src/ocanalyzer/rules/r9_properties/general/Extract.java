package ocanalyzer.rules.r9_properties.general;

import java.util.List;

import org.eclipse.jdt.core.dom.FieldDeclaration;
import org.eclipse.jdt.core.dom.IVariableBinding;
import org.eclipse.jdt.core.dom.VariableDeclarationFragment;

public class Extract {

	@SuppressWarnings("rawtypes")
	public List fieldFragments;

	@SuppressWarnings("rawtypes")
	private Extract(List fieldFragments) {
		super();
		this.fieldFragments = fieldFragments;
	}

	public void into(VariableBindings bindings) {
		for (Object object : fieldFragments) {
			VariableDeclarationFragment variableDeclaration = (VariableDeclarationFragment) object;
			IVariableBinding binding = variableDeclaration.resolveBinding();
			bindings.add(binding);
		}
	}

	@SuppressWarnings("rawtypes")
	public static Extract the(FieldDeclaration fieldDeclaration) {
		List fieldFragments = fieldDeclaration.fragments();
		return new Extract(fieldFragments);
	}
}