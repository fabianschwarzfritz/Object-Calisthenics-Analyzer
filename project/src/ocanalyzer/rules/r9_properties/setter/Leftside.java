package ocanalyzer.rules.r9_properties.setter;

import ocanalyzer.rules.r9_properties.general.VariableBindings;

import org.eclipse.jdt.core.dom.Assignment;
import org.eclipse.jdt.core.dom.Expression;

class Leftside {

	private Assignment node;

	public Leftside(Assignment node) {
		super();
		this.node = node;
	}

	public boolean isParameter(VariableBindings bindings) {
		Expression leftSide = node.getLeftHandSide();
		return Side.contains(leftSide, bindings);
	}
}
