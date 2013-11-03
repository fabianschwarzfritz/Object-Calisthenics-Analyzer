package ocanalyzer.rules.wrapPrimitivesAndStrings;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.jdt.core.dom.ITypeBinding;

public class PrimitiveDeterminator {

	private static final String VOID_NAME = "void";
	private static final String STRING_NAME = "String";

	private static final Set<String> WRAPPER_NAMES;

	static {
		WRAPPER_NAMES = new HashSet<String>();

		WRAPPER_NAMES.add("Number");
		WRAPPER_NAMES.add("Integer");
		WRAPPER_NAMES.add("Double");
		WRAPPER_NAMES.add("Float");
		WRAPPER_NAMES.add("Long");
		WRAPPER_NAMES.add("Short");

		WRAPPER_NAMES.add("BigInteger");
		WRAPPER_NAMES.add("BigDecimal");

		WRAPPER_NAMES.add("AtomicInteger");
		WRAPPER_NAMES.add("AtomicLong");

		WRAPPER_NAMES.add("Byte");

		WRAPPER_NAMES.add("Character");

		WRAPPER_NAMES.add("Boolean");
	}

	public boolean isPrimitive(ITypeBinding resolveTypeBinding) {
		boolean primitive = resolveTypeBinding.isPrimitive()
				& !isPrimitive(resolveTypeBinding, VOID_NAME);

		boolean string = resolveTypeBinding.getName().equals(STRING_NAME);

		boolean isWrapperPrimitive = false;
		for (String typeName : WRAPPER_NAMES) {
			if (isPrimitive(resolveTypeBinding, typeName)) {
				isWrapperPrimitive = true;
				break;
			}
		}

		return primitive || string || isWrapperPrimitive;// || literal;
	}

	private boolean isPrimitive(ITypeBinding resolveTypeBinding, String typeName) {
		return resolveTypeBinding.getName().equals(typeName);
	}
}
