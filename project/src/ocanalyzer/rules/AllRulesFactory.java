package ocanalyzer.rules;

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

	private RuleValidatorFactory indentationFactory;
	private RuleValidatorFactory elseFactory;
	private RuleValidatorFactory wrapPrimitivesFactory;
	private RuleValidatorFactory instanceVariableFactory;

	public AllRulesFactory(ICompilationUnit unit,
			CompilationUnit compilationUnit, RuleViolationReporter reporter) {
		super(unit, compilationUnit, reporter);
		elseFactory = new ElseFactory(unit, compilationUnit, reporter);
		indentationFactory = new IndentationFactory(unit, compilationUnit,
				reporter);
		wrapPrimitivesFactory = new WrapPrimitivesFactory(unit,
				compilationUnit, reporter);
		instanceVariableFactory = new InstanceVariableFactory(unit,
				compilationUnit, reporter);
	}

	@Override
	public Rules createRules() {
		Rules rules = new Rules(unit);
		rules.addRule(indentationFactory.create());
		rules.addRule(elseFactory.create());
		rules.addRule(wrapPrimitivesFactory.create());
		rules.addRule(instanceVariableFactory.create());
		return rules;
	}
}
