package ocanalyzer.rules.r9_properties.setter;

import java.util.concurrent.atomic.AtomicBoolean;

import ocanalyzer.rules.general.ViolationHandler;
import ocanalyzer.rules.r9_properties.general.ContainsBindingsVisitor;
import ocanalyzer.rules.r9_properties.general.VariableBindings;

import org.eclipse.jdt.core.dom.ASTNode;
import org.eclipse.jdt.core.dom.Expression;

class Side implements ViolationHandler {

	private AtomicBoolean contains;

	private Side(AtomicBoolean contains) {
		this.contains = contains;
	}

	public static boolean contains(Expression expression,
			VariableBindings bindings) {
		final AtomicBoolean contains = new AtomicBoolean();
		ViolationHandler handler = new Side(contains);
		expression.accept(new ContainsBindingsVisitor(expression, bindings,
				handler));
		return contains.get();
	}

	@Override
	public void printInfo(ASTNode node) {
		contains.set(true);
	}

	@Override
	public void printInfo(ASTNode type, String customMessage) {
		contains.set(true);
	}

}
