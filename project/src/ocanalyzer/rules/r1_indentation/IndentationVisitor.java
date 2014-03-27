package ocanalyzer.rules.r1_indentation;

import ocanalyzer.rules.general.ViolationHandler;
import ocanalyzer.rules.general.ViolationHandlerImpl;

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

/**
 * This visitor implements the validation of rule 1:
 * "Use only one level of Indentation per method".
 * 
 * To do so, it listens to all 'keyword'-statements (like 'do', 'while', 'for',
 * and so on) and uses {@link #indentationCheck(ASTNode, int)} to check if at
 * least the 'grandparent' in the hierarchy of statements is a method
 * declaration.
 * 
 * @author Fabian Schwarz-Fritz
 * 
 */

class IndentationVisitor extends ASTVisitor {

	private ViolationHandler violationHandler;

	public IndentationVisitor(ViolationHandler violationHandler) {
		this.violationHandler = violationHandler;
	}

	private boolean isMethod(ASTNode node) {
		return node instanceof MethodDeclaration;
	}

	private boolean indentationCheck(ASTNode node, int level) {
		boolean method = isMethod(node);
		if (level > 0 & !method) {
			return indentationCheck(node.getParent(), --level);
		}
		return method;
	}

	private boolean validateParent(Statement statement) {
		boolean correctIndentation = indentationCheck(statement, 2);
		if (!correctIndentation) {
			violationHandler.printInfo(statement);
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
