package ocanalyzer.unit;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class ShortTypeNameTest {

	private TypeNameDeterminatorMock shortName;

	@Before
	public void prepare() {
		shortName = new TypeNameDeterminatorMock();
	}

	@Test
	public void testPositive() {
		// Two camel cases
		assertTrue(shortName.matches("BinValide"));
		assertTrue(shortName.matches("Valide"));
		// 14 characters
		assertTrue(shortName.matches("Azdvfssanzezdv"));
	}

	@Test
	public void testNegative() {
		// More than two camel cases
		assertFalse(shortName.matches("BinNichtValide"));
		assertFalse(shortName.matches("IchAuchNicht"));
		// More than 14 characters
		assertFalse(shortName.matches("Azdvfssanzezdvz"));
	}
}
