package ocanalyzer.rules.indentation;

import ocanalyzer.reporter.RuleViolationReporter;
import ocanalyzer.rules.general.RuleValidatorFactory;

import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.CompilationUnit;

/**
 * This class represents a factory creating an {@link ASTVisitor} validation
 * rule 1: One indentation per line.
 * 
 * @author Fabian Schwarz-Fritz
 * 
 */
public class IndentationFactory extends RuleValidatorFactory {

	public IndentationFactory(ICompilationUnit unit,
			CompilationUnit compilationUnit, RuleViolationReporter reporter) {
		super(unit, compilationUnit, reporter);
	}

	@Override
	public ASTVisitor create() {
		IndentationValidationHandler indentationValidationHandler = new IndentationValidationHandler(
				unit, compilationUnit, reporter);
		IndentationVisitor visitor = new IndentationVisitor(
				indentationValidationHandler);
		return visitor;
	}

}
