package ocanalyzer.rules.r1_indentation;

import muell.RuleValidatorFactory;
import ocanalyzer.reporter.ClassReporter;

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
			CompilationUnit compilationUnit, ClassReporter reporter) {
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
