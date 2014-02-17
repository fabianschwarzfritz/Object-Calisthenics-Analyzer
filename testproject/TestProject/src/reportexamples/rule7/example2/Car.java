/**
 * 
 */
package reportexamples.rule7.example2;

/**
 * @author Fabian Schwarz-Fritz
 *
 */
public class Car {
	private Interior interior;
	private Exterior exterior;

	public void start() {
		interior.prepareStart();
		exterior.prepareStart();
	}
}
