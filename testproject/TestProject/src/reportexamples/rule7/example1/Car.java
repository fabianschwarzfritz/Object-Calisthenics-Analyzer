/**
 * 
 */
package reportexamples.rule7.example1;

import java.util.List;

import reportexamples.rule7.given.Door;
import reportexamples.rule7.given.Pedal;
import reportexamples.rule7.given.Radio;
import reportexamples.rule7.given.SteeringWheel;

/**
 * @author Fabian Schwarz-Fritz
 *
 */
public class Car {
	private SteeringWheel wheel;
	private Radio radio;
	private List<Pedal> pedals;
	private List<Door> doors;

	public void start() {
		wheel.unlock();
		radio.recoverStatus();
		for(Pedal pedal : pedals) {
			pedal.activateFeature();
		}
		for(Door door : doors) {
			door.activateFeature();
		}
	}
}
