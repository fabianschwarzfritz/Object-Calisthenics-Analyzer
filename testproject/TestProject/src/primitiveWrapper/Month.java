package primitiveWrapper;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Month {
	private int month;

	public Month(int numberYear) {
		this.month = numberYear;
	}

	public Date date(GregorianCalendar calendar) {
		calendar.set(Calendar.MONTH, month);
		return calendar.getTime();
	}

}
