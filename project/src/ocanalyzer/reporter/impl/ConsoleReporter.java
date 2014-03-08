package ocanalyzer.reporter.impl;

import java.io.PrintStream;

import ocanalyzer.domain.ViolationImpl;
import ocanalyzer.reporter.PackageViolation;
import ocanalyzer.reporter.ReporterImpl;

/**
 * This class is used to display information about rule violation on a given
 * {@link #stream}.
 * 
 * @author Fabian Schwarz-Fritz
 * 
 */

public class ConsoleReporter implements ReporterImpl {

	private PrintStream stream;

	public ConsoleReporter(PrintStream stream) {
		this.stream = stream;
	}

	@Override
	public void reportError(ViolationImpl violation) {
		String resourceName = violation.getResource().getName();
		stream.println("Reporting rule violation in resource: " + resourceName
				+ " in line " + violation.getLine() + " with message: '"
				+ violation.getMessage() + "'.");
	}
}
