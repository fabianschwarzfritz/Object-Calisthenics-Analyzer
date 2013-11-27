package ocanalyzer.newIntegration;

import ocanalyzer.rules.general.OCRule;
import ocanalyzer.rules.impl.OCRulesImpl;
import ocanalyzer.rules.r2_noelse.RuleElse;

import org.junit.Before;
import org.junit.Test;

public class ElseIntegration extends OCIntegration {

	private static final String PACKAGE_NAME = "elseRule";

	public ElseIntegration() {
		super(PACKAGE_NAME);
	}

	@Before
	public void initRules() {
		OCRule ruleToApply = new RuleElse(reporter);
		rules = OCRulesImpl.create();
		rules.add(ruleToApply);
	}

	@Test
	public void test() {
		rules.apply(units);
	}

}
