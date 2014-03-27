package ocanalyzer.rules.r2_noelse;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import junit.framework.TestCase;
import ocanalyzer.rules.fake.FakeUnit;
import ocanalyzer.rules.general.ViolationHandler;

import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.Statement;
import org.junit.Test;

public class ElseTest extends TestCase {

	@Test
	public void testElse() {
		// Prepare
		String code = "if(true) {} else {} ";
		CompilationUnit unit = new FakeUnit(code).createWithinClass();
		ViolationHandler handlerMock = mock(ViolationHandler.class);

		// Test
		ASTVisitor visitor = new ElseVisitor(handlerMock);
		unit.accept(visitor);

		// Verify
		verify(handlerMock).printInfo(any(Statement.class));
	}
}
