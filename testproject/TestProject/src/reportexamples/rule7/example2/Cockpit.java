/**
 * 
 */
package reportexamples.rule7.example2;

import java.util.List;

import reportexamples.rule7.given.Pedal;
import reportexamples.rule7.given.SteeringWheel;

/**
 * @author Fabian Schwarz-Fritz
 *
 */
public class Cockpit {
	private SteeringWheel wheel;
	private List<Pedal> pedals;
	
	public void prepareStart() {
		wheel.unlock();
		for(Pedal pedal : pedals) {
			pedal.activateFeature();
		}
	}
}
