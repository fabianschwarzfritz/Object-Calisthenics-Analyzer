package ocanalyzer.rules.indentation;

import java.util.HashSet;
import java.util.Set;

import ocanalyzer.rules.ValidationHandler;

import org.eclipse.jdt.core.dom.ASTNode;
import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.DoStatement;
import org.eclipse.jdt.core.dom.EnhancedForStatement;
import org.eclipse.jdt.core.dom.ForStatement;
import org.eclipse.jdt.core.dom.IfStatement;
import org.eclipse.jdt.core.dom.MethodDeclaration;
import org.eclipse.jdt.core.dom.Statement;
import org.eclipse.jdt.core.dom.SwitchStatement;
import org.eclipse.jdt.core.dom.TryStatement;
import org.eclipse.jdt.core.dom.WhileStatement;

public class IndentationVisitor extends ASTVisitor {

	private Set<ASTNode> methodDeclarations;

	private ValidationHandler validationHandler;

	public IndentationVisitor(IndentationValidationHandler validationHandler) {
		this.validationHandler = validationHandler;
		methodDeclarations = new HashSet<ASTNode>();
	}

	@Override
	public boolean visit(MethodDeclaration node) {
		methodDeclarations.add(node);
		return true;
	}

	private boolean isMethod(ASTNode node) {
		return methodDeclarations.contains(node);
	}

	private boolean indentiationCheck(ASTNode node, int level) {
		boolean method = isMethod(node);
		if (level > 0 & !method) {
			return indentiationCheck(node.getParent(), --level);
		}
		return method;
	}

	private boolean validateParent(Statement statement) {
		boolean correctIndentiation = indentiationCheck(statement, 2);
		if (!correctIndentiation) {
			validationHandler.printInfo(statement);
			return false;
		}
		return true;
	}

	@Override
	public boolean visit(DoStatement node) {
		return validateParent(node);
	}

	@Override
	public boolean visit(EnhancedForStatement node) {
		return validateParent(node);
	}

	@Override
	public boolean visit(ForStatement node) {
		return validateParent(node);
	}

	@Override
	public boolean visit(IfStatement node) {
		return validateParent(node);
	}

	@Override
	public boolean visit(SwitchStatement node) {
		return validateParent(node);
	}

	@Override
	public boolean visit(WhileStatement node) {
		return validateParent(node);
	}

	@Override
	public boolean visit(TryStatement node) {
		return validateParent(node);
	}
}
