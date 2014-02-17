package reportexamples.rule9.example1;

public class Main {
	public static void main(String[] args) {
		Speaker speaker = new Speaker();

		int volume = speaker.getVolume();
		if (volume < 10) {
			volume++;
			speaker.setVolume(volume);
		} else {
			System.out.println("It's the maximum volume already!");
		}

		speaker.setVolume(100);

		System.out.println(speaker.getVolume());
	}
}
