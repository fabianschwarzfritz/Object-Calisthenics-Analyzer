package ocanalyzer.unit;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class ShortTypeVariableTest {

	private VariableNameDeterminatorMock shortName;

	@Before
	public void prepare() {
		shortName = new VariableNameDeterminatorMock();
	}

	@Test
	public void testPositive() {
		// Two camel cases
		assertTrue(shortName.matches("variableName"));
		assertTrue(shortName.matches("var"));
		// 14 characters
		assertTrue(shortName.matches("azdvfssanzezdv"));
		assertTrue(shortName.matches("azdvFssanzezdv"));
	}

	@Test
	public void testNegative() {
		// More than two camel cases
		assertFalse(shortName.matches("binNichtValide"));
		assertFalse(shortName.matches("ichAuchNicht"));
		// More than 14 characters
		assertFalse(shortName.matches("azdvfssanzezdvz"));
		assertFalse(shortName.matches("azdvfssaNzezdvz"));
	}
}
