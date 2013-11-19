package ocanalyzer.rules.onedot.counter;

import java.util.ArrayList;
import java.util.List;

import ocanalyzer.rules.onedot.statementCounter.ArrayAccessCounter;
import ocanalyzer.rules.onedot.statementCounter.ArrayCreationCounter;
import ocanalyzer.rules.onedot.statementCounter.AssignmentCounter;
import ocanalyzer.rules.onedot.statementCounter.CastExpressionCounter;
import ocanalyzer.rules.onedot.statementCounter.ClassInstanceCreationCounter;
import ocanalyzer.rules.onedot.statementCounter.ConditionalExpressionCounter;
import ocanalyzer.rules.onedot.statementCounter.ExpressionCounter;
import ocanalyzer.rules.onedot.statementCounter.FieldAccessCounter;
import ocanalyzer.rules.onedot.statementCounter.InfixExpressionCounter;
import ocanalyzer.rules.onedot.statementCounter.InstanceofExpressionCounter;
import ocanalyzer.rules.onedot.statementCounter.MethodInvocationCounter;
import ocanalyzer.rules.onedot.statementCounter.ParenthesizedExpressionCounter;
import ocanalyzer.rules.onedot.statementCounter.PostfixExpressionCounter;
import ocanalyzer.rules.onedot.statementCounter.PrefixExpressionCounter;
import ocanalyzer.rules.onedot.statementCounter.SuperMethodInvocationCounter;

import org.eclipse.jdt.core.dom.ArrayAccess;
import org.eclipse.jdt.core.dom.ArrayCreation;
import org.eclipse.jdt.core.dom.Assignment;
import org.eclipse.jdt.core.dom.CastExpression;
import org.eclipse.jdt.core.dom.ClassInstanceCreation;
import org.eclipse.jdt.core.dom.ConditionalExpression;
import org.eclipse.jdt.core.dom.ConstructorInvocation;
import org.eclipse.jdt.core.dom.Expression;
import org.eclipse.jdt.core.dom.FieldAccess;
import org.eclipse.jdt.core.dom.InfixExpression;
import org.eclipse.jdt.core.dom.InstanceofExpression;
import org.eclipse.jdt.core.dom.MethodInvocation;
import org.eclipse.jdt.core.dom.Name;
import org.eclipse.jdt.core.dom.ParenthesizedExpression;
import org.eclipse.jdt.core.dom.PostfixExpression;
import org.eclipse.jdt.core.dom.PrefixExpression;
import org.eclipse.jdt.core.dom.QualifiedName;
import org.eclipse.jdt.core.dom.SuperMethodInvocation;

public class CounterFactory {

	public List<ExpressionCounter> createCounters(Expression expression) {

		List<ExpressionCounter> counters = new ArrayList<ExpressionCounter>();

		if (expression instanceof ArrayAccess) {
			ArrayAccess invocation = (ArrayAccess) expression;
			counters.add(new ArrayAccessCounter(invocation));
		} else if (expression instanceof ArrayCreation) {
			ArrayCreation invocation = (ArrayCreation) expression;
			counters.add(new ArrayCreationCounter(invocation));
		} else if (expression instanceof Assignment) {
			Assignment assignemnt = (Assignment) expression;
			counters.add(new AssignmentCounter(assignemnt));
		} else if (expression instanceof CastExpression) {
			CastExpression castExpression = (CastExpression) expression;
			counters.add(new CastExpressionCounter(castExpression));
		} else if (expression instanceof ClassInstanceCreation) {
			ClassInstanceCreation classInstanceExpression = (ClassInstanceCreation) expression;
			counters.add(new ClassInstanceCreationCounter(
					classInstanceExpression));
		} else if (expression instanceof ConditionalExpression) {
			ConditionalExpression conditionalExpression = (ConditionalExpression) expression;
			counters.add(new ConditionalExpressionCounter(conditionalExpression));
		} else if (expression instanceof FieldAccess) {
			FieldAccess fieldAccess = (FieldAccess) expression;
			counters.add(new FieldAccessCounter(fieldAccess));
		} else if (expression instanceof InfixExpression) {
			InfixExpression infixExpression = (InfixExpression) expression;
			counters.add(new InfixExpressionCounter(infixExpression));
		} else if (expression instanceof InstanceofExpression) {
			InstanceofExpression instanceofExpression = (InstanceofExpression) expression;
			counters.add(new InstanceofExpressionCounter(instanceofExpression));
		} else if (expression instanceof MethodInvocation) {
			MethodInvocation methodInvocation = (MethodInvocation) expression;
			counters.add(new MethodInvocationCounter(methodInvocation));
		} else if (expression instanceof ParenthesizedExpression) {
			ParenthesizedExpression parenthesizedExpression = (ParenthesizedExpression) expression;
			counters.add(new ParenthesizedExpressionCounter(
					parenthesizedExpression));
		} else if (expression instanceof PostfixExpression) {
			PostfixExpression postFixCounter = (PostfixExpression) expression;
			counters.add(new PostfixExpressionCounter(postFixCounter));
		} else if (expression instanceof PrefixExpression) {
			PrefixExpression postFixCounter = (PrefixExpression) expression;
			counters.add(new PrefixExpressionCounter(postFixCounter));
		} else if (expression instanceof SuperMethodInvocation) {
			SuperMethodInvocation superAccess = (SuperMethodInvocation) expression;
			counters.add(new SuperMethodInvocationCounter(superAccess));
		} // In Addition to the documentation this shit can happen:
			// System.out... here it is all about the search of qualified names!
		else if (expression instanceof Name) {
			Name name = (Name) expression;
			counters.add(new NameCounter(name));
		}
		return counters;
	}
}
