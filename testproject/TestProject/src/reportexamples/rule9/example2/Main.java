package reportexamples.rule9.example2;

public class Main {
	public static void main(String[] args) {
		Speaker speaker = new Speaker();

		speaker.turnup();
		speaker.adjustVolume(100);
		
		speaker.print(System.out);
	}
}
