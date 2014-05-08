package ocanalyzer.rules.r4_onedot;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import ocanalyzer.rules.fake.CodeReader;
import ocanalyzer.rules.fake.FakeUnit;
import ocanalyzer.rules.general.ViolationHandler;

import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.ExpressionStatement;
import org.junit.Test;

public class DotTest {

	@Test
	public void testDot() {
		String code = new CodeReader().readFromFile("dotRule/DotWrong.java");
		CompilationUnit unit = new FakeUnit(code).createPlain();
		ViolationHandler handlerMock = mock(ViolationHandler.class);

		ASTVisitor visitor = new DotVisitor(handlerMock);
		unit.accept(visitor);

		// verify(handlerMock, times(1)).printInfo(any(Assignment.class));
		verify(handlerMock, times(6)).printInfo(any(ExpressionStatement.class));
	}

}
