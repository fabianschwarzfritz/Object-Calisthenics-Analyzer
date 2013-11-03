package ocanalyzer.rules.wrapPrimitivesAndStrings.useWrappers;

import java.util.Set;

import ocanalyzer.reporter.RuleViolationReporter;
import ocanalyzer.rules.general.RuleValidatorFactory;
import ocanalyzer.rules.general.ValidationHandler;

import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.TypeDeclaration;

public class UseWrapperFactory extends RuleValidatorFactory {

	private Set<TypeDeclaration> types;

	public UseWrapperFactory(ICompilationUnit unit,
			CompilationUnit compilationUnit, RuleViolationReporter reporter,
			Set<TypeDeclaration> types) {
		super(unit, compilationUnit, reporter);
		this.types = types;
	}

	@Override
	public ASTVisitor create() {
		ValidationHandler primitivesValidationHandler = new UsePrimitivesViolationHandler(
				unit, compilationUnit, reporter);
		UseWrapperVisitor visitor = new UseWrapperVisitor(
				primitivesValidationHandler, types);
		return visitor;
	}

}
