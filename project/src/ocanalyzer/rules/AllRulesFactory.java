package ocanalyzer.rules;

import java.util.ArrayList;
import java.util.List;

import ocanalyzer.reporter.RuleViolationReporter;
import ocanalyzer.rules.general.RuleValidatorFactory;
import ocanalyzer.rules.indentation.IndentationFactory;
import ocanalyzer.rules.instanceVariable.InstanceVariableFactory;
import ocanalyzer.rules.noelse.ElseFactory;
import ocanalyzer.rules.wrapPrimitivesAndStrings.WrapPrimitivesFactory;

import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.dom.CompilationUnit;

/**
 * This class is a {@link RuleFactory} creating all existing rules.
 * 
 * @author Fabian Schwarz-Fritz
 * 
 */
public class AllRulesFactory extends RuleFactory {

	private List<RuleValidatorFactory> ruleFactories;

	public AllRulesFactory(ICompilationUnit unit,
			CompilationUnit compilationUnit, RuleViolationReporter reporter) {
		super(unit, compilationUnit, reporter);
		ruleFactories = new ArrayList<RuleValidatorFactory>();
		ruleFactories.add(new ElseFactory(unit, compilationUnit, reporter));
		ruleFactories.add(new IndentationFactory(unit, compilationUnit,
				reporter));
		ruleFactories.add(new WrapPrimitivesFactory(unit, compilationUnit,
				reporter));
		ruleFactories.add(new InstanceVariableFactory(unit, compilationUnit,
				reporter));
	}

	@Override
	public Rules createRules() {
		Rules rules = new Rules(unit);
		for (RuleValidatorFactory factory : ruleFactories) {
			rules.addRule(factory.create());
		}
		return rules;
	}
}
