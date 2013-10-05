package ocanalyzer.rules.noelse;

import ocanalyzer.reporter.MyReporter;
import ocanalyzer.rules.RuleValidatorFactory;

import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.CompilationUnit;

public class ElseRuleFactory extends RuleValidatorFactory {

	public ElseRuleFactory(ICompilationUnit unit,
			CompilationUnit compilationUnit, MyReporter reporter) {
		super(unit, compilationUnit, reporter);
	}

	@Override
	public ASTVisitor create() {
		ElseValidationHandler elseValidationHandler = new ElseValidationHandler(
				unit, compilationUnit, reporter);
		ElseVisitor visitor = new ElseVisitor(elseValidationHandler);
		return visitor;
	}

}
