package ocanalyzer.rules.r4_onedot.counter;

import ocanalyzer.rules.r4_onedot.expressions.Expressions;
import ocanalyzer.rules.r4_onedot.statementCounter.ExpressionCounter;

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
