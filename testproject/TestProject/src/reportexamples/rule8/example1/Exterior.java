package reportexamples.rule8.example1;

/**
 * 
 */

import java.io.PrintStream;
import java.util.List;

import reportexamples.rule7.given.Engine;

/**
 * @author Fabian Schwarz-Fritz
 * 
 */
public class Exterior {
	private Engine engine;
	private List<Door> doors;

	public void prepareStart() {
		engine.start();
		for (Door door : doors) {
			door.lockDoors();
		}
	}

	public void print(PrintStream out) {
		String engineName = engine.getName();
		out.print(engineName);
		for (Door door : doors) {
			String doorName = door.getSerialNumber();
			out.print(doorName);
		}
	}
}
