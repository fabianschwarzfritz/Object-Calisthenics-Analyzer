package ocanalyzer.integration;

import java.util.Collection;
import java.util.HashSet;

import ocanalyzer.integration.helper.ViolationAsserter;
import ocanalyzer.integration.mock.ClassViolationDecorator;
import ocanalyzer.rules.general.OCRule;
import ocanalyzer.rules.r7_instanceVariable.RuleInstanceVariable;

import org.junit.Before;

public class VariableCountIntegration extends IntegrationTest {

	public VariableCountIntegration() {
		super("instanceVariableCount");
	}

	@Override
	public void prepareViolations() {
		Collection<ClassViolationDecorator> violations = new HashSet<ClassViolationDecorator>();

		String className = "InstanceVariableCountWrong.java";
		String ruleViolationName = "More than two instance variables. That violates rule 7!";
		ClassViolationDecorator violation2 = new ClassViolationDecorator(
				className, 3, ruleViolationName);

		violations.add(violation2);
		asserter = new ViolationAsserter(violations);
	}

	@Override
	protected OCRule doInitRule() {
		return new RuleInstanceVariable(asserter);
	}

}
