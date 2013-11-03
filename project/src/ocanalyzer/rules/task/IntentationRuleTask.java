package ocanalyzer.rules.task;

import java.util.List;

import ocanalyzer.reporter.RuleViolationReporter;
import ocanalyzer.rules.RuleFactory;
import ocanalyzer.test.integration.mock.indentationRule.IndentiationRuleFactory;

import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.ITypeRoot;
import org.eclipse.jdt.core.dom.CompilationUnit;

public class IntentationRuleTask extends ValidationTask {

	public IntentationRuleTask(List<CompilationUnit> unitsToAnalyze,
			RuleViolationReporter reporter) {
		super(unitsToAnalyze, reporter);
	}

	@Override
	public void execute() {
		for (CompilationUnit compilationUnit : unitsToAnalyze) {
			ITypeRoot typeRoot = compilationUnit.getTypeRoot();
			// This must be a ICompilationunit because nothing else was
			// extracted
			ICompilationUnit iCompilationUnit = (ICompilationUnit) typeRoot;
			RuleFactory ruleFactory = getRuleFactory(iCompilationUnit,
					compilationUnit);
			ruleFactory.createRules().validate();
		}
	}

	protected RuleFactory getRuleFactory(ICompilationUnit iCompilationUnit,
			CompilationUnit compilationUnit) {
		return new IndentiationRuleFactory(iCompilationUnit, compilationUnit,
				reporter);
	}

}
