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

public class DotIntegration {

	private static final String PACKAGE_NAME = "dotRule";

	private OCIntegration test;
	private ViolationAsserter asserter;

	@Before
	public void prepareViolations() {
		Collection<ClassViolationDecorator> violations = new HashSet<ClassViolationDecorator>();

		String className = "DotWrong.java";
		String ruleViolationName = "Using more that one dot per line violates rule 4!";
		ClassViolationDecorator violation1 = new ClassViolationDecorator(
				className, 9, ruleViolationName);
		ClassViolationDecorator violation2 = new ClassViolationDecorator(
				className, 10, ruleViolationName);

		violations.add(violation1);
		violations.add(violation2);
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
