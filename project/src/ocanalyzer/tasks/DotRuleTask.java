package ocanalyzer.tasks;

import java.util.List;

import ocanalyzer.reporter.Reporter;
import ocanalyzer.rules.DotRuleFactory;
import ocanalyzer.rules.RuleFactory;

import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.dom.CompilationUnit;

public class DotRuleTask extends ValidationTask implements RuleFactoryProvider {

	public DotRuleTask(List<CompilationUnit> unitsToAnalyze,
			Reporter reporter) {
		super(unitsToAnalyze, reporter);
	}

	public RuleFactory createRuleFactory(ICompilationUnit iCompilationUnit,
			CompilationUnit compilationUnit) {
		return new DotRuleFactory(iCompilationUnit, compilationUnit, reporter);
	}

}