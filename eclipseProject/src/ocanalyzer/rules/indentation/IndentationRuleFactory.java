package ocanalyzer.rules.indentation;

import ocanalyzer.reporter.RuleViolationReporter;
import ocanalyzer.rules.RuleValidatorFactory;

import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.CompilationUnit;

public class IndentationRuleFactory extends RuleValidatorFactory {

	public IndentationRuleFactory(ICompilationUnit unit,
			CompilationUnit compilationUnit) {
		super(unit, compilationUnit);
	}

	public IndentationRuleFactory(ICompilationUnit unit,
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
