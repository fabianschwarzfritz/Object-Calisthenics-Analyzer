package reportexamples.rule9.example2;

import java.io.PrintStream;

public interface Noisy {

	public abstract void adjustVolume(int volume);

	public abstract void turnup();

	public abstract void print(PrintStream out);

}
