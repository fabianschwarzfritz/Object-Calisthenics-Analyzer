package ocanalyzer.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RunDTO {

	private Date time;
	private List<ViolationDTO> violations;

	public RunDTO() {
		this.time = new Date();
		violations = new ArrayList<>();
	}

	public RunDTO(Date time, List<ViolationDTO> violations) {
		super();
		this.time = time;
		this.violations = violations;
	}

	public Date getTime() {
		return time;
	}

	public List<ViolationDTO> getViolations() {
		return violations;
	}

}
