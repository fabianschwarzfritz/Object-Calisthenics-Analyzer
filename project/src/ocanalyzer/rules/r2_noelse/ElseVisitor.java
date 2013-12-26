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
		Statement elseStatement = ifStatement.getElseStatement();
		if (elseStatement != null) {
			validationHandler.printInfo(elseStatement);
		}
	}

}
