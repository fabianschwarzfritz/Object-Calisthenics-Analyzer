package primitiveWrapper;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DomainDate {

	private DateInYear dateInYear;
	private Year year;

	public DomainDate(Date date) {
		GregorianCalendar calendar = new GregorianCalendar();
		calendar.setTime(date);
		year = new Year(calendar.get(Calendar.YEAR));
		Day day = new Day(calendar.get(Calendar.DAY_OF_MONTH));
		Month month = new Month(calendar.get(Calendar.MONTH));
		dateInYear = new DateInYear(day, month);

	}

	public DomainDate(Day day, Month month, Year year) {
		super();
		this.dateInYear = new DateInYear(day, month);
		this.year = year;
	}

	public DomainTime until(DomainDate date) {
		return new DomainTime(this, date);
	}

	public Date date() {
		GregorianCalendar calendar = new GregorianCalendar();
		year.date(calendar);
		return dateInYear.date(calendar);
	}

}
