package ocanalyzer.rules.r6_small;

import java.util.HashMap;

import ocanalyzer.rules.general.ValidationHandler;

import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.ExpressionStatement;
import org.eclipse.jdt.core.dom.Statement;
import org.eclipse.jdt.core.dom.TypeDeclaration;

/**
 * 
 * This class is used to visit all if {@link Statement}.
 * 
 * An if {@link Statement} which does have a corresponding else
 * {@link Statement} is saved and furthermore it is reported to the given
 * {@link SmallValidationHandler}
 * 
 * @author Fabian Schwarz-Fritz
 * 
 */
public class SmallVisitor extends ASTVisitor {

	private ValidationHandler validationHandler;

	private TypeDeclaration current;
	private HashMap<TypeDeclaration, Integer> expressionStatements;

	public SmallVisitor(ValidationHandler validatonHandler) {
		this.validationHandler = validatonHandler;
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
			validationHandler.printInfo(node);
		}
	}

	@Override
	public void endVisit(ExpressionStatement node) {
		Integer value = expressionStatements.get(current);
		System.err.println("expressionastaksljdf");
		expressionStatements.put(current, ++value);
	}

}
