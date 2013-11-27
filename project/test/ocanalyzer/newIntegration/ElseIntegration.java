package ocanalyzer.newIntegration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

import java.util.List;

import ocanalyzer.reporter.ClassViolation;
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

		List<ClassViolation> violations = reporter.getViolations();

		assertSame(1, violations.size());
		ClassViolation violation = violations.get(0);
		assertEquals("Error when validating no-else rule. Wrong resource",
				"ElseWrong.java", violation.getResource().getName());
		assertEquals("Error when validating no-else rule. Wring position",
				new Integer(8), violation.getLine());
		assertEquals("Error when validating no-else rule. Wring message",
				"The else keyword violates rule 2", violation.getMessage());
	}

}
