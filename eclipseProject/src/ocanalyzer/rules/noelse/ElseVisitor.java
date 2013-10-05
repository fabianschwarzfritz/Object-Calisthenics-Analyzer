package ocanalyzer.rules.noelse;

import java.util.ArrayList;
import java.util.List;

import ocanalyzer.rules.ValidationHandler;

import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.IfStatement;
import org.eclipse.jdt.core.dom.Statement;

/**
 * 
 * This class is used to visit all if {@link Statement}.
 * 
 * An if {@link Statement} which does have a corresponding else
 * {@link Statement} is saved and furthermore it is reported to the given
 * {@link ElseValidationHandler}
 * 
 * @author Fabian Schwarz-Fritz
 * 
 */
public class ElseVisitor extends ASTVisitor {

	private List<Statement> elseStatements;
	private ValidationHandler validationHandler;

	public ElseVisitor(ValidationHandler validatonHandler) {
		this.validationHandler = validatonHandler;
		elseStatements = new ArrayList<Statement>();
	}

	@Override
	public void endVisit(IfStatement ifStatement) {
		if (isSingleElse(ifStatement)) {
			Statement elseStatement = ifStatement.getElseStatement();
			elseStatements.add(elseStatement);
			validationHandler.printInfo(ifStatement);
		}
	}

	private boolean isSingleElse(IfStatement ifStatement) {
		return ifStatement.getElseStatement() != null;
	}

	public List<Statement> getElseStatements() {
		return elseStatements;
	}

}
