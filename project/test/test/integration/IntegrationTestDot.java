package test.integration;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import ocanalyzer.analyzer.factory.ExtractorFactory;
import ocanalyzer.analyzer.factory.extractor.PackageExtractor;
import ocanalyzer.analyzer.reporter.TestReporter;
import ocanalyzer.handlers.DotHandlerMock;
import ocanalyzer.handlers.ObjectCalisthenics;
import ocanalyzer.reporter.ClassViolation;
import ocanalyzer.reporter.Reporter;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IResource;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.IPackageFragment;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

public class IntegrationTestDot {

	@Spy
	@InjectMocks
	private ObjectCalisthenics oc;
	@Mock
	private TestReporter reporterMock;
	@Mock
	private ExtractorFactory factory;

	@Before
	public void prepare() throws JavaModelException {
		CompilationUnit coUnit = mock(CompilationUnit.class);
		final List<CompilationUnit> coUnits = new ArrayList<CompilationUnit>();
		coUnits.add(coUnit);

		reporterMock = mock(TestReporter.class);

		ICompilationUnit compilationUnit = mock(ICompilationUnit.class);
		ICompilationUnit[] units = new ICompilationUnit[] { compilationUnit };

		IPackageFragment fragment = mock(IPackageFragment.class);
		when(fragment.getCompilationUnits()).thenReturn(units);

		PackageExtractor packageExtractor = mock(PackageExtractor.class);

		factory = mock(ExtractorFactory.class);
		when(factory.createPackageAnalyzer(fragment)).thenReturn(
				packageExtractor);

		oc = mock(ObjectCalisthenics.class);
		// oc = spy(ocMock);

		doNothing().when(oc).applyTask(coUnits);

		// DotRuleTask task = new DotRuleTask(coUnits, reporterMock);
		// task.execute();

	}

	@Test
	public void testDotRule() throws ExecutionException {
		IResource resourceMock = mock(IResource.class);
		when(resourceMock.getName()).thenReturn("DotWrong.java");
		MockitoAnnotations.initMocks(this);

		oc.execute(null);

		verify(reporterMock).reportError(
				new ClassViolation(resourceMock, new Integer(9),
						"Using more that one dot per line violates rule 4!"));

		// List<ClassViolation> violations = reporterMock.getViolations();
		//
		// assertSame(2, violations.size());
		//
		// ClassViolation violation1 = violations.get(0);
		// assertEquals("Error when validating dot rule. Wrong resource",
		// "DotWrong.java", violation1.getResource().getName());
		// assertEquals("Error when validating dot rule. Wrong position",
		// new Integer(9), violation1.getLine());
		// assertEquals("Error when validating dot rule. Wrong message",
		// "Using more that one dot per line violates rule 4!",
		// violation1.getMessage());
		//
		// ClassViolation violation2 = violations.get(1);
		// assertEquals("Error when validating dot rule. Wrong resource",
		// "DotWrong.java", violation2.getResource().getName());
		// assertEquals("Error when validating dot rule. Wrong position",
		// new Integer(10), violation2.getLine());
		// assertEquals("Error when validating dot rule. Wrong message",
		// "Using more that one dot per line violates rule 4!",
		// violation2.getMessage());

	}
}
