package ocanalyzer.rules.task;

import java.util.List;

import ocanalyzer.reporter.RuleViolationReporter;
import ocanalyzer.rules.RuleFactory;

import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.ITypeRoot;
import org.eclipse.jdt.core.dom.CompilationUnit;

public abstract class ValidationTask {

	protected List<CompilationUnit> unitsToAnalyze;
	protected RuleViolationReporter reporter;

	public ValidationTask(List<CompilationUnit> unitsToAnalyze,
			RuleViolationReporter reporter) {
		super();
		this.unitsToAnalyze = unitsToAnalyze;
		this.reporter = reporter;
	}

	public abstract void execute();

	public abstract RuleFactory getRuleFactory(
			ICompilationUnit iCompilationUnit, CompilationUnit compilationUnit);

	protected void validate(List<CompilationUnit> unitsToAnalyze) {
		for (CompilationUnit compilationUnit : unitsToAnalyze) {
			ITypeRoot typeRoot = compilationUnit.getTypeRoot();
			// This must be a ICompilationunit because nothing else was
			// extracted
			ICompilationUnit iCompilationUnit = (ICompilationUnit) typeRoot;
			RuleFactory ruleFactory = getRuleFactory(iCompilationUnit,
					compilationUnit);
			ruleFactory.createRules().validate();
		}
	}

}
