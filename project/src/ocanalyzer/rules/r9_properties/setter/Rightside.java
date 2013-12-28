package ocanalyzer.rules.r9_properties.setter;

import ocanalyzer.rules.r9_properties.general.VariableBindings;

import org.eclipse.jdt.core.dom.Assignment;
import org.eclipse.jdt.core.dom.Expression;

class Rightside {

	private Assignment node;

	public Rightside(Assignment node) {
		super();
		this.node = node;
	}

	public boolean isParameter(VariableBindings bindings) {
		Expression rightSide = node.getRightHandSide();
		return Side.contains(rightSide, bindings);
	}

}
