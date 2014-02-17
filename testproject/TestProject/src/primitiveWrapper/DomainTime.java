package primitiveWrapper;

import java.util.Date;

public class DomainTime {

	private DomainDate start;
	private DomainDate stop;

	public DomainTime(DomainDate start, DomainDate stop) {
		super();
		this.start = start;
		this.stop = stop;
	}

	public Amount numberOfDays() {
		Date startDate = start.date();
		Date stopDate = stop.date();
		int diffInDays = (int) ((stopDate.getTime() - startDate.getTime()) / (1000 * 60 * 60 * 24));
		return new Amount(diffInDays, "Tage");
	}

}
