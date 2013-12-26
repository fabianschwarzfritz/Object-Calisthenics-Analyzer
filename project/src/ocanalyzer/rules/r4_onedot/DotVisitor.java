package ocanalyzer.rules.r4_onedot;

import ocanalyzer.rules.general.ValidationHandler;
import ocanalyzer.rules.r4_onedot.counter.CounterReporter;
import ocanalyzer.rules.r4_onedot.counter.StatementDotCounter;

import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.ExpressionStatement;
import org.eclipse.jdt.core.dom.Statement;
import org.eclipse.jdt.core.dom.TypeDeclaration;

/**
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
		return true;
	}

	@Override
	public boolean visit(final ExpressionStatement node) {
		StatementDotCounter statementDotCounter = new StatementDotCounter(node,
				new CounterReporter() {
					@Override
					public void count(int count) {
						if (count > 1) {
							validationHandler.printInfo(node);
						}
					}
				});
		statementDotCounter.count();
		return true;
	}
}
