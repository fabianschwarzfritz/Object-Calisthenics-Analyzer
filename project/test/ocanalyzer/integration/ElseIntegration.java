package ocanalyzer.integration;

import java.util.Collection;
import java.util.HashSet;

import ocanalyzer.integration.helper.ViolationAsserter;
import ocanalyzer.integration.mock.ClassViolationDecorator;
import ocanalyzer.rules.general.OCRule;
import ocanalyzer.rules.r2_noelse.RuleElse;

import org.junit.Before;

public class ElseIntegration extends IntegrationTest {

	public ElseIntegration() {
		super("elseRule");
	}

	@Override
	public void prepareViolations() {
		Collection<ClassViolationDecorator> violations = new HashSet<ClassViolationDecorator>();
		ClassViolationDecorator violation = new ClassViolationDecorator(
				"ElseWrong.java", 8, "The else keyword violates rule 2");
		violations.add(violation);
		ClassViolationDecorator violation2 = new ClassViolationDecorator(
				"ElseWrong.java", 10, "The else keyword violates rule 2");

		violations.add(violation);
		violations.add(violation2);

		asserter = new ViolationAsserter(violations);
	}

	@Override
	protected OCRule doInitRule() {
		return new RuleElse(asserter);
	}

}
