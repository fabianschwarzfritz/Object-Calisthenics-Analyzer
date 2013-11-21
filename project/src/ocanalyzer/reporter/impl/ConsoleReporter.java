package ocanalyzer.reporter.impl;

import java.io.PrintStream;

import ocanalyzer.reporter.ClassReporter;
import ocanalyzer.reporter.ClassViolation;
import ocanalyzer.reporter.PackageReporter;
import ocanalyzer.reporter.PackageViolation;

/**
 * This class is used to display information about rule violation on a given
 * {@link #stream}.
 * 
 * @author Fabian Schwarz-Fritz
 * 
 */

public class ConsoleReporter implements ClassReporter, PackageReporter {

	private PrintStream stream;

	public ConsoleReporter(PrintStream stream) {
		this.stream = stream;
	}

	@Override
	public void reportError(ClassViolation violation) {
		String resourceName = violation.getResource().getName();
		stream.println("Reporting validation in resource: " + resourceName
				+ " in line " + violation.getLine() + " with message: '"
				+ violation.getMessage() + "'.");
	}

	@Override
	public void reportError(PackageViolation violation) {
		String resourceName = violation.getResource().toString();
		stream.println("Reporting validation in resource: " + resourceName
				+ " with message: '" + violation.getMessage() + "'.");
	}
}
