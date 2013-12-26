package ocanalyzer.rules.r2_noelse;

import ocanalyzer.rules.general.ValidationHandlerImpl;

import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.IfStatement;
import org.eclipse.jdt.core.dom.Statement;

/**
 * 
 * @author Fabian Schwarz-Fritz
 * 
 */
public class ElseVisitor extends ASTVisitor {

	private ValidationHandlerImpl validationHandler;

	public ElseVisitor(ValidationHandlerImpl validatonHandler) {
		this.validationHandler = validatonHandler;
	}

	@Override
	public void endVisit(IfStatement ifStatement) {
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
