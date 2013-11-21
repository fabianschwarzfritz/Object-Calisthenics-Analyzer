package ocanalyzer.rules.r3_8_wrap.determinator;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.jdt.core.dom.ITypeBinding;

public class PrimitiveDeterminator extends TypeDeterminator {

	private static final String VOID_NAME = "V";
	private static final String STRING_NAME = "String";

	private static final Set<String> WRAPPER_NAMES;

	static {
		WRAPPER_NAMES = new HashSet<String>();

		WRAPPER_NAMES.add("java.lang.Number");
		// WRAPPER_NAMES.add("java.lang.Integer");
		// WRAPPER_NAMES.add("java.lang.Double");
		// WRAPPER_NAMES.add("java.lang.Float");
		// WRAPPER_NAMES.add("java.lang.Long");
		// WRAPPER_NAMES.add("java.lang.Short");

		// WRAPPER_NAMES.add("java.math.BigInteger");
		// WRAPPER_NAMES.add("java.math.BigDecimal");

		// WRAPPER_NAMES.add("java.util.concurrent.atomic.AtomicInteger");
		// WRAPPER_NAMES.add("java.util.concurrent.atomic.AtomicLong");

		// WRAPPER_NAMES.add("java.lang.Byte");

		WRAPPER_NAMES.add("java.lang.Character");

		WRAPPER_NAMES.add("java.lang.Boolean");
	}

	public boolean determineType(ITypeBinding resolveTypeBinding) {
		boolean primitive = resolveTypeBinding.isPrimitive()
				& !isType(resolveTypeBinding, VOID_NAME);

		String typeName = resolveTypeBinding.getName();
		boolean string = typeName.equals(STRING_NAME);

		boolean isWrapperPrimitive = isPermittedType(resolveTypeBinding,
				WRAPPER_NAMES);

		return primitive || string || isWrapperPrimitive;
	}

}
