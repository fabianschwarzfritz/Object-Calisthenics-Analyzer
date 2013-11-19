package ocanalyzer.rules;

import ocanalyzer.reporter.Reporter;
import ocanalyzer.rules.general.RuleValidatorFactory;
import ocanalyzer.rules.noelse.ElseFactory;

import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.dom.CompilationUnit;

public class InstanceVariableRuleFactory extends RuleFactory {

	private RuleValidatorFactory instanceFactory;

	public InstanceVariableRuleFactory(ICompilationUnit unit,
			CompilationUnit compilationUnit, Reporter reporter) {
		super(unit, compilationUnit, reporter);
		instanceFactory = new ElseFactory(unit, compilationUnit, reporter);
	}

	@Override
	public Rules createRules() {
		Rules rules = new Rules(unit);
		rules.add(instanceFactory.create());
		return rules;
	}
}
