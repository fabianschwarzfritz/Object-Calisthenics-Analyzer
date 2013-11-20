package ocanalyzer.rules;

import ocanalyzer.reporter.ClassReporter;
import ocanalyzer.rules.general.RuleValidatorFactory;
import ocanalyzer.rules.r4_onedot.DotFactory;

import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.dom.CompilationUnit;

public class DotRuleFactory extends RuleFactory {

	private RuleValidatorFactory dotFactory;

	public DotRuleFactory(ICompilationUnit unit,
			CompilationUnit compilationUnit, ClassReporter reporter) {
		super(unit, compilationUnit, reporter);
		dotFactory = new DotFactory(unit, compilationUnit, reporter);
	}

	@Override
	public Rules createRules() {
		Rules rules = new Rules(unit);
		rules.add(dotFactory.create());
		return rules;
	}

}
