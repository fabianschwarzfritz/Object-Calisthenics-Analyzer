package ocanalyzer.rules.wrapTypes.determinator;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.jdt.core.dom.ITypeBinding;

public class CollectionDeterminator extends TypeDeterminator {

	private static final Set<String> WRAPPER_NAMES;

	static {
		WRAPPER_NAMES = new HashSet<String>();

		WRAPPER_NAMES.add("java.util.Collection");
		WRAPPER_NAMES.add("java.util.List");
		WRAPPER_NAMES.add("java.util.Set");
		WRAPPER_NAMES.add("java.util.Map");
	}

	public boolean determineType(ITypeBinding resolveTypeBinding) {
		System.out.println();
		System.out.println(resolveTypeBinding.getBinaryName());

		boolean array = resolveTypeBinding.isArray();
		boolean isCollection = isPermittedType(resolveTypeBinding,
				WRAPPER_NAMES);

		return array || isCollection;// || literal;
	}
}
