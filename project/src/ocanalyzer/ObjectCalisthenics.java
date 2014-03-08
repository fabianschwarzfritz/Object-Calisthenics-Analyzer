package ocanalyzer;

import ocanalyzer.extractor.Extractor;
import ocanalyzer.extractor.impl.ExtractorImpl;
import ocanalyzer.reporter.ReporterImpl;
import ocanalyzer.rules.OCRules;
import ocanalyzer.rules.general.ICompilationUnits;
import ocanalyzer.rules.impl.OCRulesImpl;

import org.eclipse.core.runtime.Status;

public class ObjectCalisthenics {

	private Extractor extractor;
	private OCRules rules;

	public static ObjectCalisthenics create(ReporterImpl reporter) {
		return new ObjectCalisthenics(new ExtractorImpl(),
				OCRulesImpl.createStandardRules(reporter));
	}

	public ObjectCalisthenics(Extractor extractor, OCRules rules) {
		super();
		this.extractor = extractor;
		this.rules = rules;
	}

	public void validate() {
		long extraction = System.nanoTime();
		ICompilationUnits units = extractor.extract();
		long extractionTime = System.nanoTime() - extraction;
		System.err.println("Extraction took  " + extractionTime + "ns.  = "
				+ (double) extractionTime / 1000000000.0 + "s.");

		long apply = System.nanoTime();

		try {
			rules.apply(units);
		} catch (Exception ex) {
			Activator.getLogger().log(
					new Status(Status.ERROR, Activator.PLUGIN_ID,
							"Error when applying rule (" + rules
									+ ") on units (" + units + ").", ex));
		}
		long applyTime = System.nanoTime() - apply;
		System.err.println("Applying took  " + extractionTime + "ns.  = "
				+ (double) applyTime / 1000000000.0 + "s.");
	}

}
