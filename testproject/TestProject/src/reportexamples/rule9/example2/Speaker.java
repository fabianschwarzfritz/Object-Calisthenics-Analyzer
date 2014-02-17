package reportexamples.rule9.example2;

import java.io.PrintStream;

public class Speaker implements Noisy {

	/* the volume from one to ten */
	private int volume;

	public Speaker() {
		volume = 3;
	}

	public void adjustVolume(int volume) {
		if (isNotInRange(volume)) {
			System.out.println("Given volume is not in range form one to ten!");
			return;
		}
		this.volume = volume;
	}

	public void turnup() {
		if (isNotInRange(volume)) {
			System.out.println("It's the maximum volume already!");
		}
		volume++;
	}

	public void print(PrintStream out) {
		out.println(volume);
	}

	private static boolean isNotInRange(int volume) {
		return !isInRange(volume);
	}

	private static boolean isInRange(int volume) {
		return 1 <= volume & volume <= 10;
	}

}
