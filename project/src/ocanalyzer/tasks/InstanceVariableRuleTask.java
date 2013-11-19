package ocanalyzer.tasks;

import java.util.List;

import ocanalyzer.reporter.Reporter;
import ocanalyzer.rules.InstanceVariableRuleFactory;
import ocanalyzer.rules.RuleFactory;

import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.dom.CompilationUnit;

public class InstanceVariableRuleTask extends ValidationTask implements
		RuleFactoryProvider {

	public InstanceVariableRuleTask(List<CompilationUnit> unitsToAnalyze,
			Reporter reporter) {
		super(unitsToAnalyze, reporter);
	}

	public RuleFactory createRuleFactory(ICompilationUnit iCompilationUnit,
			CompilationUnit compilationUnit) {
		return new InstanceVariableRuleFactory(iCompilationUnit,
				compilationUnit, reporter);
	}

}
