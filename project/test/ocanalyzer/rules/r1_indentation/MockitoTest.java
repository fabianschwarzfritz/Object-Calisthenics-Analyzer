package ocanalyzer.rules.r1_indentation;

// import static org.mockito.Mockito.*; 
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import junit.framework.TestCase;
import ocanalyzer.domain.ViolationImpl;
import ocanalyzer.extractor.Extractor;
import ocanalyzer.extractor.impl.ExtractorFactory;
import ocanalyzer.extractor.impl.ExtractorImpl;
import ocanalyzer.integration.mock.MockAnalyzerFactory;
import ocanalyzer.reporter.Reporter;
import ocanalyzer.rules.general.ICompilationUnits;
import ocanalyzer.rules.general.ViolationHandlerImpl;

import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

public class MockitoTest extends TestCase {

	private ICompilationUnits units;

	@Override
	public void setUp() {
		ExtractorFactory factory = new MockAnalyzerFactory("indentationRule");
		Extractor extractor = new ExtractorImpl(factory);
		units = extractor.extract();
	}

	public void testIndentation2() {
		
		final IndentationViolationHandler handlerMock = mock(IndentationViolationHandler.class);
		final Reporter reporterMock = mock(Reporter.class);
		final RuleIndentation ruleIndentationMock = mock(RuleIndentation.class);
//		RuleIndentation ruleIndentationMock = new RuleIndentation(reporterMock);
		// stub(ruleIndentationMock.apply(any(ICompilationUnits.class)));

		doAnswer(new Answer<Void>() {
			@Override
			public Void answer(InvocationOnMock invocation) throws Throwable {
				System.out.println(invocation);
				final IndentationVisitor visitor = new IndentationVisitor(
						handlerMock);
				return null;
			}
		}).when(ruleIndentationMock).apply(any(ICompilationUnits.class));

		verify(reporterMock, times(1)).reportError(any(ViolationImpl.class));
	}

	public void testIndentation() {
		// --- Mock ---
		Reporter reporterMock = mock(Reporter.class);
		ViolationImpl violationMock = mock(ViolationImpl.class);
		ViolationHandlerImpl violationHandlerMock = mock(ViolationHandlerImpl.class);
		// --- Apply ---
		RuleIndentation rule = new RuleIndentation(reporterMock);
		rule.apply(units);
		// --- Verify ---
		verify(reporterMock, times(1)).reportError(any(ViolationImpl.class));
//		verfity(reporterMock.)
//		verify(reporterMock).reportError(violationMock);
	}
}
