package ocanalyzer.rules;

import ocanalyzer.reporter.RuleViolationReporter;
import ocanalyzer.rules.general.RuleValidatorFactory;
import ocanalyzer.rules.indentation.IndentationFactory;
import ocanalyzer.rules.noelse.ElseFactory;

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

	public AllRulesFactory(ICompilationUnit unit,
			CompilationUnit compilationUnit, RuleViolationReporter reporter) {
		super(unit, compilationUnit, reporter);
		elseFactory = new ElseFactory(unit, compilationUnit, reporter);
		indentationFactory = new IndentationFactory(unit, compilationUnit,
				reporter);
	}

	@Override
	public Rules createRules() {
		Rules rules = new Rules(unit);
		rules.addRule(indentationFactory.create());
		rules.addRule(elseFactory.create());
		return rules;
	}
}
