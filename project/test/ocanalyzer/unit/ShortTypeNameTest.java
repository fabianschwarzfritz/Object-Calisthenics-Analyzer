package ocanalyzer.unit;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import ocanalyzer.rules.r5_shortnames.determinator.TypeNameDeterminator;

import org.junit.Before;
import org.junit.Test;

public class ShortTypeNameTest {

	private TypeNameDeterminator shortName;

	@Before
	public void prepare() {
		shortName = new TypeNameDeterminator();
	}

	@Test
	public void testPositive() {
		// Two camel cases
		assertTrue(shortName.shortName("BinValide"));
		assertTrue(shortName.shortName("Valide"));
		// 14 characters
		assertTrue(shortName.shortName("Azdvfssanzezdv"));
	}

	@Test
	public void testNegative() {
		// More than two camel cases
		assertFalse(shortName.shortName("BinNichtValide"));
		assertFalse(shortName.shortName("IchAuchNicht"));
		// More than 14 characters
		assertFalse(shortName.shortName("Azdvfssanzezdvz"));
	}
}
