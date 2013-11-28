package ocanalyzer.newIntegration;

import java.util.Collection;
import java.util.HashSet;

import ocanalyzer.rules.general.OCRule;
import ocanalyzer.rules.impl.OCRulesImpl;
import ocanalyzer.rules.r4_onedot.RuleOneDotPerLine;

import org.junit.Before;
import org.junit.Test;

public class DotIntegration {

	private static final String PACKAGE_NAME = "elseRule";

	private OCIntegration test;
	private ViolationAsserter asserter;

	@Before
	public void prepareViolations() {
		Collection<ClassViolationDecorator> violations = new HashSet<ClassViolationDecorator>();
		ClassViolationDecorator violation = new ClassViolationDecorator(
				"DotWrong.java", 9,
				"Using more that one dot per line violates rule 4!");
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
