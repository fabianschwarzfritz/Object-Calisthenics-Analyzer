package ocanalyzer.rules.impl;

import ocanalyzer.reporter.ClassReporter;
import ocanalyzer.rules.general.RuleValidatorFactory;
import ocanalyzer.rules.r2_noelse.ElseFactory;

import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.dom.CompilationUnit;

public class ElseRuleFactory extends RuleFactory {

	private RuleValidatorFactory elseFactory;

	public ElseRuleFactory(ICompilationUnit unit,
			CompilationUnit compilationUnit, ClassReporter reporter) {
		super(unit, compilationUnit, reporter);
		elseFactory = new ElseFactory(unit, compilationUnit, reporter);
	}

	@Override
	public RulesClass createRules() {
		RulesClass rules = new RulesClass(unit);
		rules.add(elseFactory.create());
		return rules;
	}
}
