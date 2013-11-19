package ocanalyzer.rules.onedot.statementCounter;

import ocanalyzer.rules.onedot.expressions.Expressions;

import org.eclipse.jdt.core.dom.ArrayCreation;
import org.eclipse.jdt.core.dom.ArrayInitializer;

public class ArrayCreationCounter implements ExpressionCounter {

	private ArrayCreation array;

	public ArrayCreationCounter(ArrayCreation arr) {
		this.array = arr;
	}

	@SuppressWarnings("unchecked")
	public void extractExpressions(Expressions expressions) {
		expressions.add(array.dimensions());
		ArrayInitializer initializer = array.getInitializer();
		ArrayInitializerCounter arrayInitcounter = new ArrayInitializerCounter(
				initializer);
		arrayInitcounter.extractExpressions(expressions);
	}

}
