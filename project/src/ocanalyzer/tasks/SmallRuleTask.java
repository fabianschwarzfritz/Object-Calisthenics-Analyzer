package ocanalyzer.tasks;

import java.util.List;

import ocanalyzer.reporter.Reporter;
import ocanalyzer.rules.RuleFactory;
import ocanalyzer.rules.SmallRulesFactory;

import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.dom.CompilationUnit;

public class SmallRuleTask extends ValidationTask implements
		RuleFactoryProvider {

	public SmallRuleTask(List<CompilationUnit> unitsToAnalyze, Reporter reporter) {
		super(unitsToAnalyze, reporter);
	}

	public RuleFactory createRuleFactory(ICompilationUnit iCompilationUnit,
			CompilationUnit compilationUnit) {
		return new SmallRulesFactory(iCompilationUnit, compilationUnit,
				reporter);
	}

}
