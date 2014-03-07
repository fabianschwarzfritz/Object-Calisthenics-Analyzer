package ocanalyzer.integration;

import java.util.Collection;
import java.util.HashSet;

import ocanalyzer.integration.helper.ViolationAsserter;
import ocanalyzer.integration.mock.ClassViolationDecorator;
import ocanalyzer.rules.general.OCRule;
import ocanalyzer.rules.r38_wrap.RuleWrapNew;

public class WrapperIntegration extends IntegrationTest {

	public WrapperIntegration() {
		super("primitiveWrapper");
	}

	@Override
	public void prepareViolations() {
		Collection<ClassViolationDecorator> violations = new HashSet<ClassViolationDecorator>();

		String className = "Amount.java";

		String ruleViolationName = "is already wrapper for something else";
		ClassViolationDecorator violation = new ClassViolationDecorator(
				className, 6, ruleViolationName);

		String ruleViolationName2 = "returning boolean not allowed";
		ClassViolationDecorator violation2 = new ClassViolationDecorator(
				className, 14, ruleViolationName2);

		violations.add(violation);
		violations.add(violation2);
		asserter = new ViolationAsserter(violations);
	}

	@Override
	protected OCRule doInitRule() {
		return new RuleWrapNew(asserter);
	}

}
