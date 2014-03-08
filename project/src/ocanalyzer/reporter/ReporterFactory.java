package ocanalyzer.reporter;

import ocanalyzer.reporter.impl.ConsoleReporter;
import ocanalyzer.reporter.impl.DelegateReporter;
import ocanalyzer.reporter.impl.MarkerReporter;

public class ReporterFactory {

	public static Reporter createStandardReporter() {
		DelegateReporter result = new DelegateReporter();
		result.addReporter(new ConsoleReporter(System.out));
		result.addReporter(new MarkerReporter());
		return result;
	}

	public static Reporter createConsoleReporter() {
		return new ConsoleReporter(System.out);
	}

}
