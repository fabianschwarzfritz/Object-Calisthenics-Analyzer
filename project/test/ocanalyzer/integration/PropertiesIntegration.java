package ocanalyzer.integration;

import java.util.Collection;
import java.util.HashSet;

import ocanalyzer.integration.helper.OCIntegration;
import ocanalyzer.integration.helper.ViolationAsserter;
import ocanalyzer.integration.mock.ClassViolationDecorator;
import ocanalyzer.rules.general.OCRule;
import ocanalyzer.rules.impl.OCRulesImpl;
import ocanalyzer.rules.r9_properties.RuleProperties;

import org.junit.Before;
import org.junit.Test;

public class PropertiesIntegration {

	private static final String PACKAGE_NAME = "properties_wrong";

	private OCIntegration test;
	private ViolationAsserter asserter;

	@Before
	public void prepareViolations() {
		Collection<ClassViolationDecorator> violations = new HashSet<ClassViolationDecorator>();

		String className = "Properties.java";
		String ruleViolationName = "The use of getter/setter/properties violates rule 9";
		ClassViolationDecorator violation = new ClassViolationDecorator(
				className, 12, ruleViolationName);

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
		OCRule ruleToApply = new RuleProperties(asserter);
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
