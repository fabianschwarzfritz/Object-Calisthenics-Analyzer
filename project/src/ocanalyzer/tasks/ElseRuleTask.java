package ocanalyzer.tasks;

import java.util.List;

import ocanalyzer.reporter.Reporter;
import ocanalyzer.rules.ElseRuleFactory;
import ocanalyzer.rules.RuleFactory;

import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.dom.CompilationUnit;

public class ElseRuleTask extends ValidationTask implements RuleFactoryProvider {

	public ElseRuleTask(List<CompilationUnit> unitsToAnalyze,
			Reporter reporter) {
		super(unitsToAnalyze, reporter);
	}

	public RuleFactory createRuleFactory(ICompilationUnit iCompilationUnit,
			CompilationUnit compilationUnit) {
		return new ElseRuleFactory(iCompilationUnit, compilationUnit, reporter);
	}

}
