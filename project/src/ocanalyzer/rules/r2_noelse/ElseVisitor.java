package ocanalyzer.rules.r2_noelse;

import ocanalyzer.rules.general.ViolationHandler;

import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.IfStatement;
import org.eclipse.jdt.core.dom.Statement;

/**
 * This visitor implements the validation of rule 2:
 * "Don�t Use the else Keyword".
 * 
 * The visitor get notified about all if-statements and with the object
 * representation of the {@link IfStatement}, the can get the object
 * representation of the corresponding else part. When there is an else as part
 * of an {@link IfStatement}, a violation is reported.
 * 
 * @author Fabian Schwarz-Fritz
 * 
 */
class ElseVisitor extends ASTVisitor {

	private ViolationHandler violationHandler;

	public ElseVisitor(ViolationHandler violationHandler) {
		this.violationHandler = violationHandler;
	}

	@Override
	public void endVisit(IfStatement ifStatement) {
		Statement elseStatement = ifStatement.getElseStatement();
		if (elseStatement != null) {
			violationHandler.printInfo(elseStatement);
		}
	}
// TODO loggin einbauen und in file schreiben
	// TODOfeedback form mit emial einbauen
}
