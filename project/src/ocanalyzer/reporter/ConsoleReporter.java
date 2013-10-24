package ocanalyzer.reporter;

import java.io.PrintStream;

import org.eclipse.core.resources.IResource;

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
	public void reportError(IResource resource, int line, String msg) {
		stream.println("Reporting validation in resource: "
				+ resource.getName() + " in line " + line + " with message: '"
				+ msg + "'.");
	}

}
