package ocanalyzer.rules.r1_indentation;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;
import ocanalyzer.rules.fake.CodeReader;
import ocanalyzer.rules.fake.FakeUnit;
import ocanalyzer.rules.general.ViolationHandler;

import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.ForStatement;
import org.eclipse.jdt.core.dom.Statement;
import org.junit.Test;

public class IndentationTest {

	@Test
	public void testIndentation() {
		String code = new CodeReader()
				.readFromFile("indentationRule/IndentationWrong.java");
		CompilationUnit unit = new FakeUnit(code).create();
		ViolationHandler handlerMock = mock(ViolationHandler.class);

		ASTVisitor visitor = new IndentationVisitor(handlerMock);
		unit.accept(visitor);

		verify(handlerMock, times(1)).printInfo(any(ForStatement.class));
	}
}
