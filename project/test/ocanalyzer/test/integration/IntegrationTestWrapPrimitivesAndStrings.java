package ocanalyzer.test.integration;

import static ocanalyzer.test.helper.AssertionHelper.assertTypes;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import junit.framework.TestCase;
import ocanalyzer.analyzer.AnalyzerFactory;
import ocanalyzer.reporter.Violation;
import ocanalyzer.test.integration.mock.MockAnalyzerFactory;
import ocanalyzer.test.integration.mock.TestReporter;
import ocanalyzer.test.integration.wrapPrimitivesAndStrings.WrapPrimitivesObjectCalisthenicsHandlerMock;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jdt.core.dom.TypeDeclaration;

public class IntegrationTestWrapPrimitivesAndStrings extends TestCase {

	public void testWrapperClassesDatabase() throws ExecutionException {
		TestReporter testReporter = new TestReporter();
		AnalyzerFactory factory = new MockAnalyzerFactory(
				"wrapPrimitives_wrong_db");
		WrapPrimitivesObjectCalisthenicsHandlerMock ocMock = new WrapPrimitivesObjectCalisthenicsHandlerMock(
				factory, testReporter);

		ocMock.execute(null);

		List<Violation> violations = testReporter.getViolations();

		assertSame(1, violations.size());
		Violation violation = violations.get(0);
		assertEquals(
				"Error finding a primitive/string wrapper. Wrong resource",
				"DBConfiguration.java", violation.getResource().getName());
		assertEquals(
				"Error finding a primitive/string wrapper. Wrong position",
				new Integer(3), violation.getLine());

	}

	public void testWrapperClassesBirthday() throws ExecutionException {
		Set<String> assertTypes = new HashSet<String>();
		assertTypes.add("Month");
		assertTypes.add("Day");
		String packageName = "wrapPrimitives_correct_birthday";

		testWrappers(assertTypes, packageName);
	}

	public void testMinimalistic() throws ExecutionException {
		Set<String> assertTypes = new HashSet<String>();
		assertTypes.add("MinimalisticMethodSignature");
		assertTypes.add("MinimalisticConstructor");
		String packageName = "wrapPrimitives_correct_mimimalistic";

		testWrappers(assertTypes, packageName);
	}

	public void testClassesDatabase2() throws ExecutionException {
		Set<String> assertTypes = new HashSet<String>();
		assertTypes.add("DatabaseName");
		assertTypes.add("HostName");
		assertTypes.add("Port");
		assertTypes.add("DBConfiguration");
		String packageName = "wrapPrimitives_correct_db";

		testWrappers(assertTypes, packageName);
	}

	private void testWrappers(Set<String> assertTypes, String packageName)
			throws ExecutionException {
		TestReporter testReporter = new TestReporter();
		AnalyzerFactory factory = new MockAnalyzerFactory(packageName);
		WrapPrimitivesObjectCalisthenicsHandlerMock ocMock = new WrapPrimitivesObjectCalisthenicsHandlerMock(
				factory, testReporter);

		ocMock.execute(null);

		Set<TypeDeclaration> wrappers = ocMock.getWrappers();

		assertTypes(assertTypes, wrappers);
	}

}
