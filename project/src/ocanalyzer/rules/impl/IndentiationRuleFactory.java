package ocanalyzer.rules.impl;

import ocanalyzer.reporter.ClassReporter;
import ocanalyzer.rules.general.RuleValidatorFactory;
import ocanalyzer.rules.r1_indentation.IndentationFactory;

import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.dom.CompilationUnit;

public class IndentiationRuleFactory extends RuleFactory {

	private RuleValidatorFactory indentiationFactory;

	public IndentiationRuleFactory(ICompilationUnit unit,
			CompilationUnit compilationUnit, ClassReporter reporter) {
		super(unit, compilationUnit, reporter);
		indentiationFactory = new IndentationFactory(unit, compilationUnit,
				reporter);
	}

	@Override
	public RulesClass createRules() {
		RulesClass rules = new RulesClass(unit);
		rules.add(indentiationFactory.create());
		return rules;
	}
}