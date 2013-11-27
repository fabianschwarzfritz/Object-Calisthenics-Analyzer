package ocanalyzer.newIntegration;

import ocanalyzer.rules.general.OCRule;
import ocanalyzer.rules.impl.OCRulesImpl;
import ocanalyzer.rules.r4_onedot.RuleOneDotPerLine;

import org.junit.Before;
import org.junit.Test;

public class DotIntegration extends OCIntegration {

	private static final String PACKAGE_NAME = "dotRule";

	public DotIntegration() {
		super(PACKAGE_NAME);
	}

	@Before
	public void initRules() {
		OCRule ruleToApply = new RuleOneDotPerLine(reporter);
		rules = OCRulesImpl.create();
		rules.add(ruleToApply);
	}

	@Test
	public void test() {
		rules.apply(units);
	}

}
