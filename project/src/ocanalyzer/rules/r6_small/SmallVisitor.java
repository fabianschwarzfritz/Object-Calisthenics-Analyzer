package ocanalyzer.rules.r6_small;

import java.util.HashMap;

import ocanalyzer.rules.general.ViolationHandler;

import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.AssertStatement;
import org.eclipse.jdt.core.dom.ConstructorInvocation;
import org.eclipse.jdt.core.dom.DoStatement;
import org.eclipse.jdt.core.dom.ExpressionStatement;
import org.eclipse.jdt.core.dom.FieldDeclaration;
import org.eclipse.jdt.core.dom.ForStatement;
import org.eclipse.jdt.core.dom.IfStatement;
import org.eclipse.jdt.core.dom.ImportDeclaration;
import org.eclipse.jdt.core.dom.MethodDeclaration;
import org.eclipse.jdt.core.dom.ReturnStatement;
import org.eclipse.jdt.core.dom.SuperConstructorInvocation;
import org.eclipse.jdt.core.dom.SwitchCase;
import org.eclipse.jdt.core.dom.SwitchStatement;
import org.eclipse.jdt.core.dom.SynchronizedStatement;
import org.eclipse.jdt.core.dom.ThrowStatement;
import org.eclipse.jdt.core.dom.TypeDeclaration;
import org.eclipse.jdt.core.dom.WhileStatement;

class SmallVisitor extends ASTVisitor {

	private ViolationHandler violationHandler;

	private TypeDeclaration current;
	private HashMap<TypeDeclaration, Integer> expressionStatements;

	public SmallVisitor(ViolationHandler violationHandler) {
		this.violationHandler = violationHandler;
		expressionStatements = new HashMap<TypeDeclaration, Integer>();
	}

	@Override
	public boolean visit(TypeDeclaration node) {
		current = node;
		expressionStatements.put(current, 0);
		return true;
	}

	@Override
	public void endVisit(TypeDeclaration node) {
		if (expressionStatements.get(node) > 50) {
			violationHandler.printInfo(node);
		}
	}

	@Override
	public void endVisit(final ExpressionStatement node) {
		add();
	}

	@Override
	public void endVisit(WhileStatement node) {
		add();
	}

	@Override
	public void endVisit(AssertStatement node) {
		add();
	}

	@Override
	public void endVisit(ConstructorInvocation node) {
		add();
	}

	@Override
	public void endVisit(DoStatement node) {
		add();
	}

	@Override
	public void endVisit(ForStatement node) {
		add();
	}

	@Override
	public void endVisit(IfStatement node) {
		add();
	}

	@Override
	public void endVisit(ReturnStatement node) {
		add();
	}

	@Override
	public void endVisit(SuperConstructorInvocation node) {
		add();
	}

	@Override
	public void endVisit(SwitchCase node) {
		add();
	}

	@Override
	public void endVisit(SwitchStatement node) {
		add();
	}

	@Override
	public void endVisit(SynchronizedStatement node) {
		add();
	}

	@Override
	public void endVisit(ThrowStatement node) {
		add();
	}

	@Override
	public void endVisit(FieldDeclaration node) {
		add();
	}

	@Override
	public void endVisit(MethodDeclaration node) {
		add();
	}

	@Override
	public void endVisit(ImportDeclaration node) {
		add();
	}

	private void add() {
		if (current != null) {
			int value = expressionStatements.get(current);
			expressionStatements.put(current, ++value);
		}
	}

}
