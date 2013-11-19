package ocanalyzer.rules;

import java.util.ArrayList;
import java.util.List;

import ocanalyzer.reporter.Reporter;
import ocanalyzer.rules.general.RuleValidatorFactory;
import ocanalyzer.rules.indentation.IndentationFactory;
import ocanalyzer.rules.instanceVariable.InstanceVariableFactory;
import ocanalyzer.rules.noelse.ElseFactory;

import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.dom.CompilationUnit;

public class PreRulesFactory extends RuleFactory {

	private List<RuleValidatorFactory> ruleFactories;

	public PreRulesFactory(ICompilationUnit unit,
			CompilationUnit compilationUnit, Reporter reporter) {
		super(unit, compilationUnit, reporter);
		ruleFactories = new ArrayList<RuleValidatorFactory>();
		ruleFactories.add(new ElseFactory(unit, compilationUnit, reporter));
		ruleFactories.add(new IndentationFactory(unit, compilationUnit,
				reporter));
		ruleFactories.add(new InstanceVariableFactory(unit, compilationUnit,
				reporter));
	}

	@Override
	public Rules createRules() {
		Rules rules = new Rules(unit);
		for (RuleValidatorFactory factory : ruleFactories) {
			rules.add(factory.create());
		}
		return rules;
	}
}
