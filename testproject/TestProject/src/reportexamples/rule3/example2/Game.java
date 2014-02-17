package reportexamples.rule3.example2;

public class Game {

	public static void main(String[] args) {
		Dice one = new Dice();
		one.roll(new Action() {
			@Override
			public void count(int count) {
				System.out.println("You will jump " + count + " times.");
			}

			@Override
			public void rollValue(int number) {
				System.out.println("Jump number " + number);
			}
		});
	}

}
