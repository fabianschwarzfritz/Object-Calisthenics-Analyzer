package ocanalyzer.rules.r9_properties;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import ocanalyzer.rules.fake.CodeReader;
import ocanalyzer.rules.fake.FakeUnit;
import ocanalyzer.rules.general.ViolationHandler;
import ocanalyzer.rules.r9_properties.general.PublicVisitor;

import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.Statement;
import org.junit.Test;

public class PropertiesTest {

	@Test
	public void testProperties() {
		String code = new CodeReader()
				.readFromFile("properties_wrong/PropertiesPublic.java");
		CompilationUnit unit = new FakeUnit(code).createPlain();
		ViolationHandler handlerMock = mock(ViolationHandler.class);

		ASTVisitor visitor = new PublicVisitor(handlerMock);
		unit.accept(visitor);

		verify(handlerMock, times(1)).printInfo(any(Statement.class));
	}
}
