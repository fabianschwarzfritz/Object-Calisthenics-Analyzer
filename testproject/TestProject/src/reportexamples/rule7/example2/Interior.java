/**
 * 
 */
package reportexamples.rule7.example2;

/**
 * @author Fabian Schwarz-Fritz
 *
 */
public class Interior {
	private CenterConsole console;
	private Cockpit cockpit;

	public void prepareStart() {
		console.prepareStart();
		cockpit.prepareStart();
	}
}
