package ocanalyzer.domain;

import ocanalyzer.extractor.Extractor;
import ocanalyzer.rules.general.ICompilationUnits;

public class Project {

	private Extractor extractor;
	private ICompilationUnits allUnits;

	public Project(Extractor extractor) {
		super();
		this.extractor = extractor;
	}

	public ICompilationUnits changedUnits() {
		// FIXME later the project has to to a management of version and an
		// intelligent extraction of compilation units.
		return extractor.extract();
	}

}
