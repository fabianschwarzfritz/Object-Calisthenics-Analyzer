package ocanalyzer.tasks;

import java.util.List;

import ocanalyzer.reporter.ClassReporter;
import ocanalyzer.rules.impl.InstanceVariableRuleFactory;
import ocanalyzer.rules.impl.RuleFactory;

import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.dom.CompilationUnit;

class InstanceVariableRuleTask extends ValidationTask implements
		RuleFactoryProvider {

	public InstanceVariableRuleTask(List<CompilationUnit> unitsToAnalyze,
			ClassReporter reporter) {
		super(unitsToAnalyze, reporter);
	}

	public RuleFactory createRuleFactory(ICompilationUnit iCompilationUnit,
			CompilationUnit compilationUnit) {
		return new InstanceVariableRuleFactory(iCompilationUnit,
				compilationUnit, reporter);
	}

}
