package reportexamples.rule8.example2;

/**
 * 
 */

import java.io.PrintStream;

import reportexamples.rule7.given.Engine;

/**
 * @author Fabian Schwarz-Fritz
 * 
 */
public class Exterior {
	private Engine engine;
	private Doors doors;

	public void prepareStart() {
		engine.start();
		doors.centralLock();
	}

	public void print(PrintStream out) {
		String engineName = engine.getName();
		out.print(engineName);
		doors.print(out);
	}
}
