package ocanalyzer.rules.task;

import java.util.List;

import ocanalyzer.reporter.RuleViolationReporter;
import ocanalyzer.rules.RuleFactory;
import ocanalyzer.test.integration.mock.elseRule.ElseRuleFactory;

import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.dom.CompilationUnit;

public class ElseRuleTask extends ValidationTask {

	public ElseRuleTask(List<CompilationUnit> unitsToAnalyze,
			RuleViolationReporter reporter) {
		super(unitsToAnalyze, reporter);
	}

	@Override
	public void execute() {
		validate(unitsToAnalyze);
	}

	public RuleFactory getRuleFactory(ICompilationUnit iCompilationUnit,
			CompilationUnit compilationUnit) {
		return new ElseRuleFactory(iCompilationUnit, compilationUnit, reporter);
	}

}
