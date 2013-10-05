package ocanalyzer.rules;

import ocanalyzer.reporter.MyReporter;

import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.CompilationUnit;

public abstract class RuleValidatorFactory {

	protected ICompilationUnit unit;
	protected CompilationUnit compilationUnit;
	protected MyReporter reporter;

	public RuleValidatorFactory(ICompilationUnit unit,
			CompilationUnit compilationUnit, MyReporter reporter) {
		super();
		this.unit = unit;
		this.compilationUnit = compilationUnit;
		this.reporter = reporter;
	}

	public abstract ASTVisitor create();

}
