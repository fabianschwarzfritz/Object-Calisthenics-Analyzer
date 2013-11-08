package ocanalyzer.rules.task;

import java.util.List;

import ocanalyzer.reporter.RuleViolationReporter;
import ocanalyzer.rules.InstanceVariableRuleFactory;
import ocanalyzer.rules.RuleFactory;

import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.dom.CompilationUnit;

public class InstanceVariableRuleTask extends ValidationTask implements
		RuleFactoryProvider {

	public InstanceVariableRuleTask(List<CompilationUnit> unitsToAnalyze,
			RuleViolationReporter reporter) {
		super(unitsToAnalyze, reporter);
	}

	public RuleFactory createRuleFactory(ICompilationUnit iCompilationUnit,
			CompilationUnit compilationUnit) {
		return new InstanceVariableRuleFactory(iCompilationUnit,
				compilationUnit, reporter);
	}

}
