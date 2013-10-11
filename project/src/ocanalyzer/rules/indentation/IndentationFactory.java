package ocanalyzer.rules.indentation;

import ocanalyzer.reporter.RuleViolationReporter;
import ocanalyzer.rules.general.RuleValidatorFactory;

import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.CompilationUnit;

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
