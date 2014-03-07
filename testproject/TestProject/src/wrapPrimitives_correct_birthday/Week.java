package wrapPrimitives_correct_birthday;

public class Week {

	public void everyDay(DayAction action) {
		int workdays = 5;
		int weekend = 2;

		workdays(action, workdays);
		weekend(action, workdays, weekend);
	}

	private void weekend(DayAction action, int workdays, int weekend) {
		int firstWeekend = workdays + 1;
		int lastWeekend = workdays + weekend;
		for (int i = firstWeekend; i <= lastWeekend; i++) {
			action.execute(new DayOfWeek(new Day(i), new Name("Weekend")));
		}
	}

	private void workdays(DayAction action, int workdays) {
		for (int i = 1; i <= workdays; i++) {
			action.execute(new DayOfWeek(new Day(i), new Name("Workday")));
		}
	}
}
