package ocanalyzer.rules.r4_onedot;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import ocanalyzer.rules.fake.CodeReader;
import ocanalyzer.rules.fake.FakeUnit;
import ocanalyzer.rules.general.ViolationHandler;
import ocanalyzer.rules.r4_onedot.expressions.ExpressionSet;

import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.Assignment;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.ExpressionStatement;
import org.eclipse.jdt.core.dom.ForStatement;
import org.eclipse.jdt.core.dom.Statement;
import org.junit.Test;

public class DotTest {

	@Test
	public void testDot() {
		String code = new CodeReader().readFromFile("dotRule/DotWrong.java");
		CompilationUnit unit = new FakeUnit(code).create();
		ViolationHandler handlerMock = mock(ViolationHandler.class);

		ASTVisitor visitor = new DotVisitor(handlerMock);
		unit.accept(visitor);

//		verify(handlerMock, times(1)).printInfo(any(Assignment.class));
		verify(handlerMock, times(5)).printInfo(any(ExpressionStatement.class));
	}

}
