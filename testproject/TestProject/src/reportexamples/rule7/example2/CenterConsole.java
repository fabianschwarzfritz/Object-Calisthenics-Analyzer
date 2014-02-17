/**
 * 
 */
package reportexamples.rule7.example2;

import reportexamples.rule7.given.Radio;

/**
 * @author Fabian Schwarz-Fritz
 *
 */
public class CenterConsole {
	private Radio radio;
	
	public void prepareStart() {
		radio.recoverStatus();
	}

}
