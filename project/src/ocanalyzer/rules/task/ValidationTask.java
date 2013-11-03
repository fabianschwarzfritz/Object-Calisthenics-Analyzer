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

}
