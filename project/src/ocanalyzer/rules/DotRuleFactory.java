package ocanalyzer.rules;

import ocanalyzer.reporter.RuleViolationReporter;
import ocanalyzer.rules.general.RuleValidatorFactory;
import ocanalyzer.rules.noelse.ElseFactory;

import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.dom.CompilationUnit;

public class DotRuleFactory extends RuleFactory {

	private RuleValidatorFactory dotFactory;

	public DotRuleFactory(ICompilationUnit unit,
			CompilationUnit compilationUnit, RuleViolationReporter reporter) {
		super(unit, compilationUnit, reporter);
		dotFactory = new ElseFactory(unit, compilationUnit, reporter);
	}

	@Override
	public Rules createRules() {
		Rules rules = new Rules(unit);
		rules.add(dotFactory.create());
		return rules;
	}

}
