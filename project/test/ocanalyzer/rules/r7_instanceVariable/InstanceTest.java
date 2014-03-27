package ocanalyzer.rules.r7_instanceVariable;

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

public class InstanceTest {
	@Test
	public void testInstanceVariableCount() {
		String code = new CodeReader()
				.readFromFile("instanceVariableCount/InstanceVariableCountWrong.java");
		CompilationUnit unit = new FakeUnit(code).create();
		ViolationHandler handlerMock = mock(ViolationHandler.class);

		ASTVisitor visitor = new InstanceVariableVisitor(handlerMock);
		unit.accept(visitor);

		verify(handlerMock, times(1)).printInfo(any(Statement.class));
	}
}
