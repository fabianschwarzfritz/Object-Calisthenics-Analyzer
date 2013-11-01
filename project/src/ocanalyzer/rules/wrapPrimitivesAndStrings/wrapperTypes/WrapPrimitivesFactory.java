package ocanalyzer.rules.wrapPrimitivesAndStrings.wrapperTypes;

import java.util.Set;

import ocanalyzer.reporter.RuleViolationReporter;
import ocanalyzer.rules.general.RuleValidatorFactory;
import ocanalyzer.rules.general.ValidationHandler;
import ocanalyzer.rules.wrapPrimitivesAndStrings.WrapPrimitivesValidationHandler;

import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.TypeDeclaration;

public class WrapPrimitivesFactory extends RuleValidatorFactory {

	private Set<TypeDeclaration> types;

	public WrapPrimitivesFactory(ICompilationUnit unit,
			CompilationUnit compilationUnit, RuleViolationReporter reporter,
			Set<TypeDeclaration> types) {
		super(unit, compilationUnit, reporter);
		this.types = types;
	}

	@Override
	public ASTVisitor create() {
		ValidationHandler primitivesValidationHandler = new WrapPrimitivesValidationHandler(
				unit, compilationUnit, reporter);
		WrapPrimitivesVisitor visitor = new WrapPrimitivesVisitor(
				primitivesValidationHandler, types);
		return visitor;
	}

}
