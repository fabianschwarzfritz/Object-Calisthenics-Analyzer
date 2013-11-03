package wrapPrimitives_wrong_birthday;

import java.math.BigInteger;
import java.util.concurrent.atomic.AtomicInteger;

public class PrimitivesWrong {

	public void operation() {
		Integer day = 15;
		BigInteger big = new BigInteger("2");
		AtomicInteger atom = new AtomicInteger();

		Byte b = new Byte("1");
		Character c = new Character('s');
		Boolean bol = new Boolean(true);

		int month = 10;

		System.out.println("Fabian's Birthday: " + day + "." + month);
	}
}
