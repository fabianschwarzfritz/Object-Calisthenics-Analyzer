package ocanalyzer.rules.r9_properties.general;

import java.util.HashSet;
import java.util.Set;

import ocanalyzer.rules.general.ViolationHandler;

import org.eclipse.jdt.core.dom.IVariableBinding;
import org.eclipse.jdt.core.dom.SimpleName;

public class VariableBindings {

	private Set<IVariableBinding> bindings;

	public VariableBindings() {
		bindings = new HashSet<>();
	}

	public void clear() {
		bindings = new HashSet<>();
	}

	public void add(IVariableBinding binding) {
		bindings.add(binding);
	}

	public void print(IVariableBinding foundBinding, SimpleName node,
			ViolationHandler handler) {
		if (bindings.contains(foundBinding)) {
			handler.printInfo(node);
		}
	}

}
