package ocanalyzer.rules;

import ocanalyzer.reporter.Reporter;
import ocanalyzer.rules.general.RuleValidatorFactory;
import ocanalyzer.rules.r2_noelse.ElseFactory;

import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.dom.CompilationUnit;

public class ElseRuleFactory extends RuleFactory {

	private RuleValidatorFactory elseFactory;

	public ElseRuleFactory(ICompilationUnit unit,
			CompilationUnit compilationUnit, Reporter reporter) {
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
