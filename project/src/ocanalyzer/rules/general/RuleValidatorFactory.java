package ocanalyzer.rules.general;

import ocanalyzer.reporter.RuleViolationReporter;
import ocanalyzer.reporter.DelegateReporter;

import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.CompilationUnit;

/**
 * This class abstracts a concrete factory object validating a rule of the
 * Object Calisthenics.
 * 
 * @author Fabian Schwarz-Fritz
 * 
 */
public abstract class RuleValidatorFactory {

	protected ICompilationUnit unit;
	protected CompilationUnit compilationUnit;
	protected RuleViolationReporter reporter;

	public RuleValidatorFactory(ICompilationUnit unit,
			CompilationUnit compilationUnit) {
		super();
		this.unit = unit;
		this.compilationUnit = compilationUnit;
		reporter = new DelegateReporter();
	}

	public RuleValidatorFactory(ICompilationUnit unit,
			CompilationUnit compilationUnit, RuleViolationReporter reporter) {
		super();
		this.unit = unit;
		this.compilationUnit = compilationUnit;
		this.reporter = reporter;
	}

	public abstract ASTVisitor create();

}
