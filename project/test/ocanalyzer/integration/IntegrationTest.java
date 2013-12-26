package ocanalyzer.integration;

import ocanalyzer.integration.helper.OCIntegration;
import ocanalyzer.integration.helper.ViolationAsserter;
import ocanalyzer.rules.general.OCRule;
import ocanalyzer.rules.impl.OCRulesImpl;

import org.junit.Test;

public abstract class IntegrationTest {

	protected OCIntegration test;
	protected ViolationAsserter asserter;

	public IntegrationTest(String packageName) {
		prepareViolations();
		OCRulesImpl rules = initRules();
		test = new OCIntegration(packageName, rules);
		test.prepare();
	}

	public abstract void prepareViolations();

	public OCRulesImpl initRules() {
		OCRule ruleToApply = doInitRule();
		OCRulesImpl rules = OCRulesImpl.create();
		rules.add(ruleToApply);
		return rules;
	}

	protected abstract OCRule doInitRule();

	@Test
	public void test() {
		test.testRule();
		asserter.guarantueeCount();
	}

}
