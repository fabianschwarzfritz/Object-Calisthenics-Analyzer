package ocanalyzer.rules.r4_onedot;

import java.util.ArrayList;
import java.util.List;

import ocanalyzer.rules.general.ViolationHandler;
import ocanalyzer.rules.r4_onedot.counter.StatementDotCounter;

import org.eclipse.jdt.core.dom.ASTNode;
import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.AssertStatement;
import org.eclipse.jdt.core.dom.Assignment;
import org.eclipse.jdt.core.dom.ConstructorInvocation;
import org.eclipse.jdt.core.dom.DoStatement;
import org.eclipse.jdt.core.dom.Expression;
import org.eclipse.jdt.core.dom.ExpressionStatement;
import org.eclipse.jdt.core.dom.FieldDeclaration;
import org.eclipse.jdt.core.dom.ForStatement;
import org.eclipse.jdt.core.dom.IfStatement;
import org.eclipse.jdt.core.dom.ReturnStatement;
import org.eclipse.jdt.core.dom.SuperConstructorInvocation;
import org.eclipse.jdt.core.dom.SwitchCase;
import org.eclipse.jdt.core.dom.SwitchStatement;
import org.eclipse.jdt.core.dom.SynchronizedStatement;
import org.eclipse.jdt.core.dom.ThrowStatement;
import org.eclipse.jdt.core.dom.VariableDeclarationFragment;
import org.eclipse.jdt.core.dom.VariableDeclarationStatement;
import org.eclipse.jdt.core.dom.WhileStatement;

/**
 * 
 * * This visitor implements the validation of rule 2:
 * "Use only one dot per line!".
 * 
 * @author Fabian Schwarz-Fritz
 * 
 */
class DotVisitor extends ASTVisitor {

	private ViolationHandler violationHandler;

	public DotVisitor(ViolationHandler violationHandler) {
		this.violationHandler = violationHandler;
	}

	@Override
	public void endVisit(ExpressionStatement node) {
		count(node.getExpression(), node);
	}

	@SuppressWarnings("unchecked")
	@Override
	public void endVisit(FieldDeclaration node) {
		List<Expression> expressions = new ArrayList<>();
		List<VariableDeclarationFragment> fragments = node.fragments();
		for (VariableDeclarationFragment fragment : fragments) {
			expressions.add(fragment.getInitializer());
		}
		count(expressions, node);
	}

	@SuppressWarnings("unchecked")
	@Override
	public void endVisit(VariableDeclarationStatement node) {
		List<Expression> expressions = new ArrayList<>();
		List<VariableDeclarationFragment> fragments = node.fragments();
		for (VariableDeclarationFragment fragment : fragments) {
			expressions.add(fragment.getInitializer());
		}
		count(expressions, node);
	}

	@Override
	public void endVisit(Assignment node) {
		System.out.println("Assignment");
		List<Expression> expressions = new ArrayList<Expression>();
		expressions.add(node.getLeftHandSide());
		expressions.add(node.getRightHandSide());
		count(expressions, node);
	}

	@Override
	public void endVisit(WhileStatement node) {
		count(node.getExpression(), node);
	}

	@Override
	public void endVisit(AssertStatement node) {
		List<Expression> expressions = new ArrayList<Expression>();
		expressions.add(node.getExpression());
		expressions.add(node.getMessage());
		count(expressions, node);
	}

	@SuppressWarnings("unchecked")
	@Override
	public void endVisit(ConstructorInvocation node) {
		count(node.arguments(), node);
	}

	@Override
	public void endVisit(DoStatement node) {
		count(node.getExpression(), node);
	}

	@SuppressWarnings("unchecked")
	@Override
	public void endVisit(ForStatement node) {
		List<Expression> expressions = new ArrayList<Expression>();
		expressions.addAll(node.initializers());
		expressions.addAll(node.updaters());
		Expression expression = node.getExpression();
		if (expression != null) {
			expressions.add(expression);
		}
		count(expressions, node);
	}

	@Override
	public void endVisit(IfStatement node) {
		count(node.getExpression(), node);
	}

	@Override
	public void endVisit(ReturnStatement node) {
		count(node.getExpression(), node);
	}

	@SuppressWarnings("unchecked")
	@Override
	public void endVisit(SuperConstructorInvocation node) {
		List<Expression> expressions = new ArrayList<Expression>();
		expressions.addAll(node.arguments());
		expressions.add(node.getExpression());
		count(expressions, node);
	}

	@Override
	public void endVisit(SwitchCase node) {
		count(node.getExpression(), node);
	}

	@Override
	public void endVisit(SwitchStatement node) {
		count(node.getExpression(), node);
	}

	@Override
	public void endVisit(SynchronizedStatement node) {
		count(node.getExpression(), node);
	}

	@Override
	public void endVisit(ThrowStatement node) {
		count(node.getExpression(), node);
	}

	@SuppressWarnings("rawtypes")
	public void count(final List<Expression> expressionList, final ASTNode node) {
		int resultCount = 0;
		for (Expression expression : expressionList) {
			StatementDotCounter statementDotCounter = new StatementDotCounter(
					expression);
			resultCount += statementDotCounter.count();
		}
		handleCount(resultCount, node);
	}

	public void count(final Expression expression, final ASTNode node) {
		StatementDotCounter statementDotCounter = new StatementDotCounter(
				expression);
		handleCount(statementDotCounter.count(), node);
	}

	private void handleCount(int resultCount, ASTNode node) {
		if (resultCount > 1) {
			violationHandler.printInfo(node);
		}
	}
}
