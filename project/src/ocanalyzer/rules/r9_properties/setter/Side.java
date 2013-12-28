package ocanalyzer.rules.r9_properties.setter;

import java.util.concurrent.atomic.AtomicBoolean;

import ocanalyzer.rules.general.ViolationHandler;
import ocanalyzer.rules.r9_properties.VariableBindings;
import ocanalyzer.rules.r9_properties.general.ContainsBindingsVisitor;

import org.eclipse.jdt.core.dom.Assignment;
import org.eclipse.jdt.core.dom.Expression;

class Side {

	public static boolean contains(Assignment node, VariableBindings bindings,
			AtomicBoolean contains, ViolationHandler handler) {
		contains = new AtomicBoolean(false);
		Expression rightHandSide = node.getRightHandSide();
		rightHandSide.accept(new ContainsBindingsVisitor(rightHandSide,
				bindings, handler));
		return contains.get();
	}

}
