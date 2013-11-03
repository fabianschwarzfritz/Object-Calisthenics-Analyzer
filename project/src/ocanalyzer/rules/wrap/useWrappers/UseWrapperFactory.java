package ocanalyzer.rules.wrap.useWrappers;

import java.util.Set;

import ocanalyzer.reporter.RuleViolationReporter;
import ocanalyzer.rules.general.RuleValidatorFactory;
import ocanalyzer.rules.general.ValidationHandler;
import ocanalyzer.rules.wrapTypes.determinator.TypeDeterminator;
import ocanalyzer.rules.wrapTypes.visitor.UseWrapperVisitor;

import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.TypeDeclaration;

public class UseWrapperFactory extends RuleValidatorFactory {

	private ValidationHandler validationHandler;
	private TypeDeterminator determinator;
	private Set<TypeDeclaration> types;

	public UseWrapperFactory(ICompilationUnit unit,
			CompilationUnit compilationUnit, RuleViolationReporter reporter,
			Set<TypeDeclaration> types, ValidationHandler validationHandler,
			TypeDeterminator determinator) {
		super(unit, compilationUnit, reporter);
		this.types = types;
		this.validationHandler = validationHandler;
		this.determinator = determinator;
	}

	@Override
	public ASTVisitor create() {
		UseWrapperVisitor visitor = new UseWrapperVisitor(validationHandler,
				types, determinator);
		return visitor;
	}

}
