package ocanalyzer.rules.r2_noelse;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import ocanalyzer.rules.fake.CodeReader;
import ocanalyzer.rules.fake.FakeUnit;
import ocanalyzer.rules.general.ViolationHandler;

import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.Statement;
import org.junit.Test;

public class ElseTest {

	@Test
	public void testElse() {
		String code = "if(true) {} else {} ";
		CompilationUnit unit = new FakeUnit(code).createWithinClass();
		ViolationHandler handlerMock = mock(ViolationHandler.class);

		ASTVisitor visitor = new ElseVisitor(handlerMock);
		unit.accept(visitor);

		verify(handlerMock).printInfo(any(Statement.class));
	}

	@Test
	public void testElseTwoElse() {
		String code = new CodeReader().readFromFile("elseRule/ElseWrong.java");
		CompilationUnit unit = new FakeUnit(code).create();
		ViolationHandler handlerMock = mock(ViolationHandler.class);

		ASTVisitor visitor = new ElseVisitor(handlerMock);
		unit.accept(visitor);

		verify(handlerMock, times(2)).printInfo(any(Statement.class));
	}
}
