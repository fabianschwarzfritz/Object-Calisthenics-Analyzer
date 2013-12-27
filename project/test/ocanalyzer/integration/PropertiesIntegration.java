package ocanalyzer.integration;

import java.util.Collection;
import java.util.HashSet;

import ocanalyzer.integration.helper.ViolationAsserter;
import ocanalyzer.integration.mock.ClassViolationDecorator;
import ocanalyzer.rules.general.OCRule;
import ocanalyzer.rules.r9_properties.RuleProperties;

import org.junit.Before;

public class PropertiesIntegration extends IntegrationTest {

	public PropertiesIntegration() {
		super("properties_wrong");
	}

	@Override
	public void prepareViolations() {
		Collection<ClassViolationDecorator> violations = new HashSet<ClassViolationDecorator>();

		String className = "Properties.java";
		String ruleViolationName = "The use of getter/setter/properties violates rule 9";
		ClassViolationDecorator violation = new ClassViolationDecorator(
				className, 12, ruleViolationName);

		violations.add(violation);
		asserter = new ViolationAsserter(violations);
	}

	@Override
	protected OCRule doInitRule() {
		return new RuleProperties(asserter);
	}

}
