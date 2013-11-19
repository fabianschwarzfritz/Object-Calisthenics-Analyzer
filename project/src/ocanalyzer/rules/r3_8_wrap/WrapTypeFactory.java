package ocanalyzer.rules.r3_8_wrap;

import java.util.Set;

import ocanalyzer.reporter.Reporter;
import ocanalyzer.rules.general.RuleValidatorFactory;
import ocanalyzer.rules.general.ValidationHandler;
import ocanalyzer.rules.r3_8_wrap.determinator.TypeDeterminator;

import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.TypeDeclaration;

public class WrapTypeFactory extends RuleValidatorFactory {

	private ValidationHandler validationHandler;
	private TypeDeterminator determinator;
	private Set<TypeDeclaration> types;

	public WrapTypeFactory(ICompilationUnit unit,
			CompilationUnit compilationUnit, Reporter reporter,
			Set<TypeDeclaration> types, ValidationHandler validationHandler,
			TypeDeterminator determinator) {
		super(unit, compilationUnit, reporter);
		this.types = types;
		this.validationHandler = validationHandler;
		this.determinator = determinator;
	}

	@Override
	public ASTVisitor create() {
		WrapperVisitor visitor = new WrapperVisitor(validationHandler, types,
				determinator);
		return visitor;
	}

}