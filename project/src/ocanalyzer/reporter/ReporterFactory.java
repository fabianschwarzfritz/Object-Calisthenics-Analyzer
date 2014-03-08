package ocanalyzer.reporter;

import ocanalyzer.reporter.impl.ConsoleReporter;
import ocanalyzer.reporter.impl.DelegateReporter;
import ocanalyzer.reporter.impl.MarkerReporter;

public class ReporterFactory {

	public static ReporterImpl createStandardReporter() {
		DelegateReporter result = new DelegateReporter();
		result.addClassReporter(new ConsoleReporter(System.out));
		result.addClassReporter(new MarkerReporter());
		return result;
	}

	public static ReporterImpl createConsoleReporter() {
		return new ConsoleReporter(System.out);
	}

}
