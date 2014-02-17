package primitiveWrapper;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Day {

	private int day;

	public Day(int numberMonth) {
		this.day = numberMonth;
	}

	public Date date(GregorianCalendar calendar) {
		calendar.set(Calendar.DAY_OF_MONTH, day);
		return calendar.getTime();
	}

}
