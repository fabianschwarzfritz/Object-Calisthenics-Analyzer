package ocanalyzer.rules.onedot;

import java.util.Set;

import ocanalyzer.rules.general.ValidationHandler;

import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.Expression;
import org.eclipse.jdt.core.dom.MethodInvocation;
import org.eclipse.jdt.core.dom.Statement;
import org.eclipse.jdt.core.dom.TypeDeclaration;

/**
 * 
 * This class is used to visit all if {@link Statement}.
 * 
 * An if {@link Statement} which does have a corresponding else
 * {@link Statement} is saved and furthermore it is reported to the given
 * {@link DotValidationHandler}
 * 
 * @author Fabian Schwarz-Fritz
 * 
 */
public class DotVisitor extends ASTVisitor {

	private ValidationHandler validationHandler;

	private TypeDeclaration visitingType;
	private Set<Expression> dots;

	public DotVisitor(ValidationHandler validatonHandler) {
		this.validationHandler = validatonHandler;
	}

	public boolean visit(TypeDeclaration type) {
		visitingType = type;
		return true;
	}

	@Override
	public void endVisit(MethodInvocation node) {
		boolean containsExpression = containsExpression(node);
		if (containsExpression) {
			validationHandler.printInfo(node);
		}
	}

	private boolean containsExpression(MethodInvocation node) {
		Expression expression = node.getExpression();
		if (dots.contains(expression)) {
			return false;
		}
		dots.add(expression);
		return true;
	}

}
