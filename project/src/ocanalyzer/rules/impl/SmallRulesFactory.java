package ocanalyzer.rules.impl;

import ocanalyzer.reporter.ClassReporter;
import ocanalyzer.rules.general.RuleValidatorFactory;
import ocanalyzer.rules.r6_small.SmallFactory;

import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.dom.CompilationUnit;

public class SmallRulesFactory extends RuleFactory {

	private RuleValidatorFactory smallFactory;

	public SmallRulesFactory(ICompilationUnit unit,
			CompilationUnit compilationUnit, ClassReporter reporter) {
		super(unit, compilationUnit, reporter);
		smallFactory = new SmallFactory(unit, compilationUnit, reporter);
	}

	@Override
	public RulesClass createRules() {
		RulesClass rules = new RulesClass(unit);
		rules.add(smallFactory.create());
		return rules;
	}

}