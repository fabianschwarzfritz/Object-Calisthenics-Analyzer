package ocanalyzer.integration;

import java.util.Collection;
import java.util.HashSet;

import ocanalyzer.integration.helper.ViolationAsserter;
import ocanalyzer.integration.mock.ClassViolationDecorator;
import ocanalyzer.rules.general.OCRule;
import ocanalyzer.rules.r9_properties.RuleProperties;

public class PropertiesIntegration extends IntegrationTest {

	public PropertiesIntegration() {
		super("properties_wrong");
		// FIXME test not working yet - why?
	}

	@Override
	public void prepareViolations() {
		Collection<ClassViolationDecorator> violations = new HashSet<ClassViolationDecorator>();

		String className = "Properties.java";
		String ruleViolationName = "The use of getter/setter/properties violates rule 9";

		ClassViolationDecorator getterViolation = new ClassViolationDecorator(
				className, 12, ruleViolationName);
		ClassViolationDecorator setterViolation1 = new ClassViolationDecorator(
				className, 16, ruleViolationName);

		violations.add(getterViolation);
		violations.add(setterViolation1);
		asserter = new ViolationAsserter(violations);
	}

	@Override
	protected OCRule doInitRule() {
		return new RuleProperties(asserter);
	}

}
