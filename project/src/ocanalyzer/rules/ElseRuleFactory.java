package ocanalyzer.rules;

import ocanalyzer.reporter.RuleViolationReporter;
import ocanalyzer.rules.general.RuleValidatorFactory;
import ocanalyzer.rules.noelse.ElseFactory;

import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.dom.CompilationUnit;

public class ElseRuleFactory extends RuleFactory {

	private RuleValidatorFactory elseFactory;

	public ElseRuleFactory(ICompilationUnit unit,
			CompilationUnit compilationUnit, RuleViolationReporter reporter) {
		super(unit, compilationUnit, reporter);
		elseFactory = new ElseFactory(unit, compilationUnit, reporter);
	}

	@Override
	public Rules createRules() {
		Rules rules = new Rules(unit);
		rules.add(elseFactory.create());
		return rules;
	}
}
