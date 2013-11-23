package ocanalyzer.tasks;

import java.util.List;

import ocanalyzer.reporter.ClassReporter;
import ocanalyzer.rules.impl.RuleFactory;
import ocanalyzer.rules.impl.SmallRulesFactory;

import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.dom.CompilationUnit;

public class SmallRuleTask extends ValidationTask implements
		RuleFactoryProvider {

	public SmallRuleTask(List<CompilationUnit> unitsToAnalyze, ClassReporter reporter) {
		super(unitsToAnalyze, reporter);
	}

	public RuleFactory createRuleFactory(ICompilationUnit iCompilationUnit,
			CompilationUnit compilationUnit) {
		return new SmallRulesFactory(iCompilationUnit, compilationUnit,
				reporter);
	}

}
