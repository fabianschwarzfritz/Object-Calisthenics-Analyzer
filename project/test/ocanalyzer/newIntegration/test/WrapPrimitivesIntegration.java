package ocanalyzer.newIntegration.test;

import java.util.Collection;
import java.util.HashSet;

import ocanalyzer.newIntegration.ClassViolationDecorator;
import ocanalyzer.newIntegration.OCIntegration;
import ocanalyzer.newIntegration.ViolationAsserter;
import ocanalyzer.rules.general.OCRule;
import ocanalyzer.rules.impl.OCRulesImpl;
import ocanalyzer.rules.r4_onedot.RuleOneDotPerLine;

import org.junit.Before;
import org.junit.Test;

public class WrapPrimitivesIntegration {

	private static final String PACKAGE_NAME = "dotRule";

	private OCIntegration test;
	private ViolationAsserter asserter;

	@Before
	public void prepareViolations() {
		Collection<ClassViolationDecorator> violations = new HashSet<ClassViolationDecorator>();
		ClassViolationDecorator violation = new ClassViolationDecorator(
				"DBConfiguration.java", 3,
				"Error finding a primitive/string wrapper. Wrong position");
		violations.add(violation);
		asserter = new ViolationAsserter(violations);
	}

	@Before
	public void prepare() {
		OCRulesImpl rules = initRules();

		test = new OCIntegration(PACKAGE_NAME, rules);

		test.prepare();
	}

	private OCRulesImpl initRules() {
		OCRule ruleToApply = new RuleOneDotPerLine(asserter);
		OCRulesImpl rules = OCRulesImpl.create();
		rules.add(ruleToApply);
		return rules;
	}

	@Test
	public void test() {
		test.testRule();
		asserter.guarantueeCount();
	}

}
