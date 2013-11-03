package ocanalyzer.rules.task;

import java.util.List;

import ocanalyzer.reporter.RuleViolationReporter;
import ocanalyzer.rules.PreRulesFactory;
import ocanalyzer.rules.RuleFactory;

import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.dom.CompilationUnit;

public class PreValidationTask extends ValidationTask {

	public PreValidationTask(List<CompilationUnit> unitsToAnalyze,
			RuleViolationReporter reporter) {
		super(unitsToAnalyze, reporter);
	}

	@Override
	public void execute() {
		validate(unitsToAnalyze);
	}

	public RuleFactory getRuleFactory(ICompilationUnit iCompilationUnit,
			CompilationUnit compilationUnit) {
		return new PreRulesFactory(iCompilationUnit, compilationUnit, reporter);
	}

}
