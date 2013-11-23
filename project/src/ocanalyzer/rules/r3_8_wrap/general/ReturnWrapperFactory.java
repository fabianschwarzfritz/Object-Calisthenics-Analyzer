package ocanalyzer.rules.r3_8_wrap.general;

import java.util.Set;

import muell.RuleValidatorFactory;
import ocanalyzer.reporter.ClassReporter;
import ocanalyzer.rules.general.ValidationHandler;
import ocanalyzer.rules.r3_8_wrap.ReturnVisitor;
import ocanalyzer.rules.r3_8_wrap.determinator.TypeDeterminator;

import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.TypeDeclaration;

public class ReturnWrapperFactory extends RuleValidatorFactory {

	private ValidationHandler validationHandler;
	private TypeDeterminator determinator;
	private Set<TypeDeclaration> types;

	public ReturnWrapperFactory(ICompilationUnit unit,
			CompilationUnit compilationUnit, ClassReporter reporter,
			Set<TypeDeclaration> types, ValidationHandler validationHandler,
			TypeDeterminator determinator) {
		super(unit, compilationUnit, reporter);
		this.validationHandler = validationHandler;
		this.determinator = determinator;
		this.types = types;
	}

	@Override
	public ASTVisitor create() {
		ReturnVisitor visitor = new ReturnVisitor(validationHandler, types,
				determinator);
		return visitor;
	}

}
