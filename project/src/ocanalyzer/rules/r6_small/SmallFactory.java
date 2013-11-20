package ocanalyzer.rules.r6_small;

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
public class SmallFactory extends RuleValidatorFactory {

	public SmallFactory(ICompilationUnit unit, CompilationUnit compilationUnit,
			ClassReporter reporter) {
		super(unit, compilationUnit, reporter);
	}

	@Override
	public ASTVisitor create() {
		ValidationHandler smallViolationHandler = new SmallValidationHandler(
				unit, compilationUnit, reporter);
		SmallVisitor visitor = new SmallVisitor(smallViolationHandler);
		return visitor;
	}

}
