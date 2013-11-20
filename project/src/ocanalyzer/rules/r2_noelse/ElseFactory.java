package ocanalyzer.rules.r2_noelse;

import ocanalyzer.reporter.ClassReporter;
import ocanalyzer.rules.general.RuleValidatorFactory;
import ocanalyzer.rules.general.ValidationHandler;

import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.CompilationUnit;

/**
 * This class represents a factory creating an {@link ASTVisitor} validation
 * rule 2: Do not use the else keyword.
 * 
 * @author Fabian Schwarz-Fritz
 * 
 */
public class ElseFactory extends RuleValidatorFactory {

	public ElseFactory(ICompilationUnit unit, CompilationUnit compilationUnit,
			ClassReporter reporter) {
		super(unit, compilationUnit, reporter);
	}

	@Override
	public ASTVisitor create() {
		ValidationHandler elseValidationHandler = new ElseValidationHandler(
				unit, compilationUnit, reporter);
		ElseVisitor visitor = new ElseVisitor(elseValidationHandler);
		return visitor;
	}

}
