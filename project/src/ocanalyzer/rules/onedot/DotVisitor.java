package ocanalyzer.rules.onedot;

import ocanalyzer.rules.general.ValidationHandler;
import ocanalyzer.rules.onedot.counter.CounterReporter;
import ocanalyzer.rules.onedot.counter.StatementDotCounter;

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
 * {@link DotValidationHandler}
 * 
 * @author Fabian Schwarz-Fritz
 * 
 */
public class DotVisitor extends ASTVisitor {

	private ValidationHandler validationHandler;

	public DotVisitor(ValidationHandler validatonHandler) {
		this.validationHandler = validatonHandler;
	}

	public boolean visit(TypeDeclaration type) {
		System.out.println("TypeDeclaration: " + type.getName());
		return true;
	}

	@Override
	public boolean visit(final ExpressionStatement node) {
		StatementDotCounter statementDotCounter = new StatementDotCounter(node,
				new CounterReporter() {
					@Override
					public void count(int count) {
						System.err.println(count);
						if (count > 1) {
							validationHandler.printInfo(node);
						}
					}
				});
		statementDotCounter.count();
		return true;
	}
}
