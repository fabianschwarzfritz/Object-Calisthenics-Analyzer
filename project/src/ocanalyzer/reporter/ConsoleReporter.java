package ocanalyzer.reporter;

import java.io.PrintStream;

/**
 * This class is used to display information about rule violation on a given
 * {@link #stream}.
 * 
 * @author Fabian Schwarz-Fritz
 * 
 */

public class ConsoleReporter implements RuleViolationReporter {

	private PrintStream stream;

	public ConsoleReporter(PrintStream stream) {
		this.stream = stream;
	}

	@Override
	public void reportError(Violation violation) {
		String resourceName = violation.getResource().getName();
		stream.println("Reporting validation in resource: " + resourceName
				+ " in line " + violation.getLine() + " with message: '"
				+ violation.getMessage() + "'.");
	}

}
