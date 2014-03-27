package ocanalyzer.rules.r2_noelse;

import ocanalyzer.rules.general.ViolationHandler;

import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.IfStatement;
import org.eclipse.jdt.core.dom.Statement;

/**
 * This visitor implements the validation of rule 2:
 * "Don�t Use the else Keyword".
 * 
 * Do do so, it simply registers for all if-statements and gets the
 * corresponding else part. When there is an else as part of an
 * {@link IfStatement}, the rule violation is reported.
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

}
