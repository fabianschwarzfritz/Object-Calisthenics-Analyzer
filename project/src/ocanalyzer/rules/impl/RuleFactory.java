package ocanalyzer.rules.impl;

import ocanalyzer.reporter.ClassReporter;

import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.dom.CompilationUnit;

/**
 * This class is used to create {@link RulesClass}
 * 
 * @author Fabian Schwarz-Fritz
 * 
 */
public abstract class RuleFactory {

	protected ICompilationUnit unit;
	protected CompilationUnit compilationUnit;
	protected ClassReporter reporter;

	public RuleFactory(ICompilationUnit unit, CompilationUnit compilationUnit,
			ClassReporter reporter) {
		super();
		this.unit = unit;
		this.compilationUnit = compilationUnit;
		this.reporter = reporter;
	}

	public abstract RulesClass createRules();

}
