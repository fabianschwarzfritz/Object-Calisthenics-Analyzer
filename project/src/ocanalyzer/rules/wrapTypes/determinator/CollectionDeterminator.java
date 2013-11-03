package ocanalyzer.rules.wrapTypes.determinator;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.jdt.core.dom.ITypeBinding;

public class CollectionDeterminator extends TypeDeterminator {

	private static final Set<String> WRAPPER_NAMES;

	static {
		WRAPPER_NAMES = new HashSet<String>();

		WRAPPER_NAMES.add("List");
		WRAPPER_NAMES.add("Set");
		WRAPPER_NAMES.add("Map");
	}

	public boolean determineType(ITypeBinding resolveTypeBinding) {
		boolean array = resolveTypeBinding.isArray();
		boolean isCollection = isPermittedType(resolveTypeBinding,
				WRAPPER_NAMES);

		return array || isCollection;// || literal;
	}
}
