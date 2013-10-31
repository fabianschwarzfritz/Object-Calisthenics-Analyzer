package ocanalyzer.rules.wrapPrimitivesAndStrings;

import ocanalyzer.reporter.RuleViolationReporter;
import ocanalyzer.rules.general.RuleValidatorFactory;
import ocanalyzer.rules.general.ValidationHandler;

import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.CompilationUnit;

public class WrapPrimitivesFactory extends RuleValidatorFactory {

	public WrapPrimitivesFactory(ICompilationUnit unit,
			CompilationUnit compilationUnit, RuleViolationReporter reporter) {
		super(unit, compilationUnit, reporter);
	}

	@Override
	public ASTVisitor create() {
		ValidationHandler primitivesValidationHandler = new WrapPrimitivesValidationHandler(
				unit, compilationUnit, reporter);
		WrapPrimitivesVisitor visitor = new WrapPrimitivesVisitor(
				primitivesValidationHandler);
		return visitor;
	}

}
