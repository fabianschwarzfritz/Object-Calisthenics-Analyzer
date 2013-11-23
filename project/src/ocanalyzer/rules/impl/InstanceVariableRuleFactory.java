package ocanalyzer.rules.impl;

import ocanalyzer.reporter.ClassReporter;
import ocanalyzer.rules.general.RuleValidatorFactory;
import ocanalyzer.rules.r2_noelse.ElseFactory;

import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.dom.CompilationUnit;

public class InstanceVariableRuleFactory extends RuleFactory {

	private RuleValidatorFactory instanceFactory;

	public InstanceVariableRuleFactory(ICompilationUnit unit,
			CompilationUnit compilationUnit, ClassReporter reporter) {
		super(unit, compilationUnit, reporter);
		instanceFactory = new ElseFactory(unit, compilationUnit, reporter);
	}

	@Override
	public RulesClass createRules() {
		RulesClass rules = new RulesClass(unit);
		rules.add(instanceFactory.create());
		return rules;
	}
}
