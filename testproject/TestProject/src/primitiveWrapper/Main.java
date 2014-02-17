package primitiveWrapper;

import java.util.Date;

public class Main {
	public static void main(String[] args) {
		DomainDate birthday = new DomainDate(new Day(15), new Month(10),
				new Year(1992));
		DomainDate today = new DomainDate(new Date());

		DomainTime age = birthday.until(today);
		Amount numberOfDays = age.numberOfDays();

		StringBuffer buffer = new StringBuffer();
		numberOfDays.print(buffer);
		System.out.println(buffer.toString());
	}
}
