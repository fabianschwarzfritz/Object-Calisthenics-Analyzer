package reportexamples.rule8.example2;

import java.io.PrintStream;
import java.util.List;

public class Doors {
	private List<Door> doors;

	public void centralLock() {
		for (Door door : doors) {
			door.lockDoors();
		}
	}

	public void print(PrintStream out) {
		for (Door door : doors) {
			String doorName = door.getName();
			out.print(doorName);
		}
	}
}
