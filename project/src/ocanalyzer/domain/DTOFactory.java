package ocanalyzer.domain;

import ocanalyzer.dto.RunDTO;

public class DTOFactory {

	public static RunDTO runDTO(RunImpl run) {
		return run.createDTO();
	}

}
