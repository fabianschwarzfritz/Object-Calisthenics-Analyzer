package ocanalyzer.newIntegration;

import ocanalyzer.analyzer.reporter.TestReporter;
import ocanalyzer.rules.general.ICompilationUnits;
import ocanalyzer.rules.general.OCRule;
import ocanalyzer.rules.impl.OCRulesImpl;
import ocanalyzer.rules.r2_noelse.RuleElse;

import org.junit.Before;
import org.junit.Test;

public class ElseIntegration {

	private ICompilationUnits units;
	private TestReporter reporter;
	private OCRulesImpl rules;

	@Before
	public void initCompilationUnits() {
		// TODO extract units from package
		units = new ICompilationUnits();
	}

	@Before
	public void initTestReporter() {
		reporter = new TestReporter();
	}

	@Before
	public void initRules() {
		OCRule ruleToApply = new RuleElse(reporter);
		rules = OCRulesImpl.create();
		rules.add(ruleToApply);
	}

	@Test
	public void test() {
		// USE mock framework to guarantee so that it is pobbile to count the validaiton
		rules.apply(units);
	}

}
