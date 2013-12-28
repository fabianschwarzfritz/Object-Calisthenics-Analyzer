package ocanalyzer.rules.r9_properties.setter;

import java.util.concurrent.atomic.AtomicBoolean;

import ocanalyzer.rules.general.ViolationHandler;
import ocanalyzer.rules.r9_properties.VariableBindings;

import org.eclipse.jdt.core.dom.ASTNode;
import org.eclipse.jdt.core.dom.Assignment;

class Leftside {

	private Assignment node;

	public Leftside(Assignment node) {
		super();
		this.node = node;
	}

	public boolean isParameter(VariableBindings bindings) {
		final AtomicBoolean left = new AtomicBoolean(false);
		return Side.contains(node, bindings, left, new ViolationHandler() {
			@Override
			public void printInfo(ASTNode node) {
				left.set(true);
			}
		});
	}
}
