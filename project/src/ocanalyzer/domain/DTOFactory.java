package ocanalyzer.domain;

import ocanalyzer.dto.RunDTO;

public class DTOFactory {

	public static RunDTO runDTO(Run run) {
		RunImpl runImpl = (RunImpl) run;
		return runImpl.createDTO();
	}

}
