package primitiveWrapper;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Year {
	private int year;

	public Year(int year) {
		this.year = year;
	}

	public Date date(GregorianCalendar gregorianCalendar) {
		gregorianCalendar.set(Calendar.YEAR, year);
		return gregorianCalendar.getTime();
	}
}
