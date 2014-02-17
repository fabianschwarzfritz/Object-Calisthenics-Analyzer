/**
 * 
 */
package reportexamples.rule7.example2;

import java.util.List;

import reportexamples.rule7.given.Door;

/**
 * @author Fabian Schwarz-Fritz
 * 
 */
public class Exterior {
	private List<Door> doors;

	public void prepareStart() {
		for (Door door : doors) {
			door.activateFeature();
		}
	}
}
