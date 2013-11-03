package ocanalyzer.test.helper;

import java.util.Set;

import junit.framework.TestCase;

import org.eclipse.jdt.core.dom.TypeDeclaration;

public class AssertionHelper extends TestCase {

	public static void assertTypes(Set<String> typeNames,
			Set<TypeDeclaration> wrappers) {
		assertSame(typeNames.size(), wrappers.size());
		for (TypeDeclaration typeDeclaration : wrappers) {
			String typeName = typeDeclaration.getName().getFullyQualifiedName();
			if (!(typeNames.contains(typeName))) {
				fail("This type is not wrapper type: " + typeDeclaration);
			}
		}
	}

}
