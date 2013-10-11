package ocanalyzer.test.integration.mock.indentiationRule;

import ocanalyzer.reporter.RuleViolationReporter;
import ocanalyzer.rules.RuleFactory;
import ocanalyzer.rules.Rules;
import ocanalyzer.rules.general.RuleValidatorFactory;
import ocanalyzer.rules.indentation.IndentationFactory;

import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.dom.CompilationUnit;

public class IndentiationRuleFactory extends RuleFactory {

	private RuleValidatorFactory indentiationFactory;

	public IndentiationRuleFactory(ICompilationUnit unit,
			CompilationUnit compilationUnit, RuleViolationReporter reporter) {
		super(unit, compilationUnit, reporter);
		indentiationFactory = new IndentationFactory(unit, compilationUnit,
				reporter);
	}

	@Override
	public Rules createRules() {
		Rules rules = new Rules(unit);
		rules.addRule(indentiationFactory.create());
		return rules;
	}
}