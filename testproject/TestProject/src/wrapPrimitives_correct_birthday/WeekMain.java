package wrapPrimitives_correct_birthday;

public class WeekMain {

	public static void main(String[] args) {
		Week week = new Week();
		week.everyDay(new DayAction() {

			@Override
			public void execute(DayOfWeek dayOfWeek) {
				dayOfWeek.print(System.out);
			}
		});
	}

}
