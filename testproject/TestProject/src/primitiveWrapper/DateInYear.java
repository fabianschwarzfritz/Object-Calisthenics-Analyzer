package primitiveWrapper;

import java.util.Date;
import java.util.GregorianCalendar;

public class DateInYear {

	private Day day;
	private Month month;

	public DateInYear(Day day, Month month) {
		super();
		this.day = day;
		this.month = month;
	}

	public Date date(GregorianCalendar calendar) {
		month.date(calendar);
		return day.date(calendar);
	}

}
