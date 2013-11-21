package ocanalyzer.rules;

import java.util.ArrayList;
import java.util.List;

import ocanalyzer.reporter.ClassReporter;
import ocanalyzer.rules.general.RuleValidatorFactory;
import ocanalyzer.rules.instanceVariable.InstanceVariableFactory;
import ocanalyzer.rules.r1_indentation.IndentationFactory;
import ocanalyzer.rules.r2_noelse.ElseFactory;

import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.dom.CompilationUnit;

public class PreRulesFactory extends RuleFactory {

	private List<RuleValidatorFactory> ruleFactories;

	public PreRulesFactory(ICompilationUnit unit,
			CompilationUnit compilationUnit, ClassReporter reporter) {
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
