package ocanalyzer.rules.onedot.counter;

import ocanalyzer.rules.onedot.expressions.Expressions;
import ocanalyzer.rules.onedot.statementCounter.ExpressionCounter;

import org.eclipse.jdt.core.dom.Name;
import org.eclipse.jdt.core.dom.QualifiedName;

public class NameCounter implements ExpressionCounter {

	private Name name;

	public NameCounter(Name name) {
		this.name = name;
	}

	@Override
	public void extractExpressions(Expressions expressions) {
		if (name.isQualifiedName()) {
			QualifiedName qualifiedName = (QualifiedName) name;
			expressions.add(qualifiedName.getQualifier());
		}
	}
}
