package ocanalyzer.rules.r2_noelse;

import ocanalyzer.rules.general.ViolationHandlerImpl;

import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.IfStatement;
import org.eclipse.jdt.core.dom.Statement;

/**
 * // TODO documentation
 * @author Fabian Schwarz-Fritz
 * 
 */
public class ElseVisitor extends ASTVisitor {

	private ViolationHandlerImpl validationHandler;

	public ElseVisitor(ViolationHandlerImpl validatonHandler) {
		this.validationHandler = validatonHandler;
	}

	@Override
	public void endVisit(IfStatement ifStatement) {
		// FIXME else if has two violations
		checkIfStatement(ifStatement);
	}

	private void checkIfStatement(Statement statement) {
		if (statement instanceof IfStatement) {
			IfStatement ifStatement = (IfStatement) statement;
			Statement elseStatement = ifStatement.getElseStatement();
			// 'else if' is an 'IfStatment' within the getElseStatmenet()
			checkIfStatement(elseStatement);
			checkElse(elseStatement);
		}
	}

	private void checkElse(Statement elseStatement) {
		if (elseStatement != null) {
			validationHandler.printInfo(elseStatement);
		}
	}

}
