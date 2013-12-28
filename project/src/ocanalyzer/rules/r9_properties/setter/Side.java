package ocanalyzer.rules.r9_properties.setter;

import java.util.concurrent.atomic.AtomicBoolean;

import ocanalyzer.rules.general.ViolationHandler;
import ocanalyzer.rules.r9_properties.VariableBindings;
import ocanalyzer.rules.r9_properties.general.ContainsBindingsVisitor;

import org.eclipse.jdt.core.dom.ASTNode;
import org.eclipse.jdt.core.dom.Expression;

class Side {

	public static boolean contains(Expression expression,
			VariableBindings bindings) {
		final AtomicBoolean contains = new AtomicBoolean();
		ViolationHandler handler = new ViolationHandler() {
			@Override
			public void printInfo(ASTNode node) {
				contains.set(true);
			}
		};
		expression.accept(new ContainsBindingsVisitor(expression, bindings,
				handler));
		return contains.get();
	}

}
