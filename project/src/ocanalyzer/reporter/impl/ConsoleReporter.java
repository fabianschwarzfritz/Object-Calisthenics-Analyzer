package ocanalyzer.reporter.impl;

import java.io.PrintStream;

import ocanalyzer.domain.ViolationImpl;
import ocanalyzer.dto.ViolationDTO;
import ocanalyzer.reporter.Reporter;

/**
 * This class is used to display information about rule violation on a given
 * {@link #stream}.
 * 
 * @author Fabian Schwarz-Fritz
 * 
 */

public class ConsoleReporter implements Reporter {

	private PrintStream stream;

	public ConsoleReporter(PrintStream stream) {
		this.stream = stream;
	}

	@Override
	public void reportError(ViolationImpl violation) {
		ViolationDTO dto = violation.createDTO();
		stream.println("Reporting rule violation in resource: "
				+ dto.getResourceName() + " in line " + dto.getPosition()
				+ " with message: '" + dto.getMessage() + "'.");
	}
}
