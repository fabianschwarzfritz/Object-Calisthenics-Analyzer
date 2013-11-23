package ocanalyzer.tasks;

import java.util.List;

import ocanalyzer.reporter.ClassReporter;
import ocanalyzer.rules.impl.DotRuleFactory;
import ocanalyzer.rules.impl.RuleFactory;

import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.dom.CompilationUnit;

public class DotRuleTask extends ValidationTask implements RuleFactoryProvider {

	public DotRuleTask(List<CompilationUnit> unitsToAnalyze,
			ClassReporter reporter) {
		super(unitsToAnalyze, reporter);
	}

	public RuleFactory createRuleFactory(ICompilationUnit iCompilationUnit,
			CompilationUnit compilationUnit) {
		return new DotRuleFactory(iCompilationUnit, compilationUnit, reporter);
	}

}