package ocanalyzer.integration;

import java.util.Collection;
import java.util.HashSet;

import ocanalyzer.integration.helper.ViolationAsserter;
import ocanalyzer.integration.mock.ClassViolationDecorator;
import ocanalyzer.rules.general.OCRule;
import ocanalyzer.rules.r4_onedot.RuleOneDotPerLine;

public class DotIntegration extends IntegrationTest {

	public DotIntegration() {
		super("dotRule");
	}

	@Override
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

	@Override
	public OCRule doInitRule() {
		return new RuleOneDotPerLine(asserter);
	}
}
