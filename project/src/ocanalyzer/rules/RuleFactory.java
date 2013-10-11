package ocanalyzer.rules;

import ocanalyzer.reporter.RuleViolationReporter;
import ocanalyzer.rules.noelse.ElseFactory;

import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.dom.CompilationUnit;

/**
 * This class is used to create concrete implementations of {@link ASTVisitors}
 * implementing the rules of the Object Calisthenics.
 * 
 * It uses concrete factories for each rule (like {@link ElseFactory} for
 * rule 2 for example) to create the concrete visitors that validate a rule.
 * 
 * @author Fabian Schwarz-Fritz
 * 
 */
public abstract class RuleFactory {

	protected ICompilationUnit unit;
	protected CompilationUnit compilationUnit;
	protected RuleViolationReporter reporter;

	public RuleFactory(ICompilationUnit unit, CompilationUnit compilationUnit,
			RuleViolationReporter reporter) {
		super();
		this.unit = unit;
		this.compilationUnit = compilationUnit;
		this.reporter = reporter;
	}

	public abstract Rules createRules();

}
