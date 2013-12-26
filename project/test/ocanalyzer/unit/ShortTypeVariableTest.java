package ocanalyzer.unit;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import ocanalyzer.rules.r5_shortnames.determinator.VariableNameDeterminator;

import org.junit.Before;
import org.junit.Test;

public class ShortTypeVariableTest {

	private VariableNameDeterminator shortName;

	@Before
	public void prepare() {
		shortName = new VariableNameDeterminator();
	}

	@Test
	public void testPositive() {
		// Two camel cases
		assertTrue(shortName.shortName("variableName"));
		assertTrue(shortName.shortName("var"));
		// 14 characters
		assertTrue(shortName.shortName("azdvfssanzezdv"));
		assertTrue(shortName.shortName("azdvFssanzezdv"));
	}

	@Test
	public void testNegative() {
		// More than two camel cases
		assertFalse(shortName.shortName("binNichtValide"));
		assertFalse(shortName.shortName("ichAuchNicht"));
		// More than 14 characters
		assertFalse(shortName.shortName("azdvfssanzezdvz"));
		assertFalse(shortName.shortName("azdvfssaNzezdvz"));
	}
}
