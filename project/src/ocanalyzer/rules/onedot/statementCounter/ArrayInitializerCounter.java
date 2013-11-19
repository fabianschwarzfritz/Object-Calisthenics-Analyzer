package ocanalyzer.rules.onedot.statementCounter;

import ocanalyzer.rules.onedot.expressions.Expressions;

import org.eclipse.jdt.core.dom.ArrayInitializer;

public class ArrayInitializerCounter implements ExpressionCounter {

	private ArrayInitializer array;

	public ArrayInitializerCounter(ArrayInitializer arr) {
		this.array = arr;
	}

	@SuppressWarnings("unchecked")
	public void extractExpressions(Expressions expressions) {
		expressions.add(array.expressions());
	}

}
