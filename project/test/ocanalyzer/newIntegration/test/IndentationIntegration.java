package ocanalyzer.newIntegration.test;

import java.util.Collection;
import java.util.HashSet;

import ocanalyzer.newIntegration.helper.OCIntegration;
import ocanalyzer.newIntegration.helper.ViolationAsserter;
import ocanalyzer.newIntegration.mock.ClassViolationDecorator;
import ocanalyzer.rules.general.OCRule;
import ocanalyzer.rules.impl.OCRulesImpl;
import ocanalyzer.rules.r1_indentation.RuleIndentation;

import org.junit.Before;
import org.junit.Test;

public class IndentationIntegration {

	private static final String PACKAGE_NAME = "indentationRule";

	private OCIntegration test;
	private ViolationAsserter asserter;

	@Before
	public void prepareViolations() {
		Collection<ClassViolationDecorator> violations = new HashSet<ClassViolationDecorator>();
		ClassViolationDecorator violation = new ClassViolationDecorator(
				"IndentationWrong.java", 7,
				"The given indentation violates rule 1");
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
		OCRule ruleToApply = new RuleIndentation(asserter);
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
