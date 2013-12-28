package ocanalyzer.rules.r4_onedot;

import ocanalyzer.rules.general.ViolationHandlerImpl;
import ocanalyzer.rules.r4_onedot.counter.CounterReporter;
import ocanalyzer.rules.r4_onedot.counter.StatementDotCounter;

import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.ExpressionStatement;
import org.eclipse.jdt.core.dom.TypeDeclaration;

/**
 * 
 * * This visitor implements the validation of rule 2:
 * "Use only one dot per line!".
 * 
 * @author Fabian Schwarz-Fritz
 * 
 */
class DotVisitor extends ASTVisitor {

	private ViolationHandlerImpl validationHandler;

	public DotVisitor(ViolationHandlerImpl validatonHandler) {
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
