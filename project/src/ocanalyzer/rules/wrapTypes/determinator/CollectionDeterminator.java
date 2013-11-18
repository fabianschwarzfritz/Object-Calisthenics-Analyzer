package ocanalyzer.rules.wrapTypes.determinator;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.jdt.core.dom.ITypeBinding;

public class CollectionDeterminator extends TypeDeterminator {

	private static final Set<String> WRAPPER_NAMES;

	static {
		WRAPPER_NAMES = new HashSet<String>();

		WRAPPER_NAMES.add("java.util.Collection");
		// FIXME super determination does not work yet when using generics!!
		WRAPPER_NAMES.add("java.util.List");
		WRAPPER_NAMES.add("java.util.ArrayList");
		WRAPPER_NAMES.add("java.util.Set");
		WRAPPER_NAMES.add("java.util.HashSet");
		WRAPPER_NAMES.add("java.util.Map");
		WRAPPER_NAMES.add("java.util.HashMap");
	}

	public boolean determineType(ITypeBinding resolveTypeBinding) {
		boolean array = resolveTypeBinding.isArray();
		boolean isCollection = isPermittedType(resolveTypeBinding,
				WRAPPER_NAMES);

		return array || isCollection;
	}
}
